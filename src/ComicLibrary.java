import CRUD.Read;
import CRUD.Update;
import Comic.Comic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Scanner;

public class ComicLibrary {
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rootpassword";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/comics";
    private static Connection connection;

    public ComicLibrary() {
        connection = null;
        try {
            Class.forName(DB_DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            Scanner reader = new Scanner(System.in);
            boolean running = true;
            String[] options = {"1. Create", "2. Read", "3. Update", "4. Delete", "5. Stop"};
            while (running) {
                System.out.println("What would you like to do? [1, 2, 3, 4, 5]");
                for (String option : options) {
                    System.out.println(option);
                }
                String option = reader.nextLine();
                switch (option) {
                    // create
                    case "1" -> System.out.println("Not yet supported");
                    // read
                    case "2" -> {
                        System.out.print("Enter the name of the comic. Leave this empty and press Enter if" +
                                " you want to see all comics: ");
                        String title = reader.nextLine();
                        Read read = new Read(connection, title);
                    }
                    // update
                    case "3" -> {
                        System.out.println("Enter all the details of the comic you want to update:");
                        Comic oldComic = enterAllDetails();
                        System.out.println("Enter all the new details. If some of the details don't need to be " +
                                "updated you just need to enter the old details again:");
                        Comic newComic = enterAllDetails();
                        Update update = new Update(connection, newComic, oldComic);
                    }
                    // delete
                    case "4" -> System.out.println("Not yet supported");
                    // stop
                    case "5" -> running = false;
                    default -> System.out.println("Please enter a valid option.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Comic enterAllDetails() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the title:");
        String title = reader.nextLine();
        System.out.println("Enter the publication number:");
        int pn = Integer.parseInt(reader.nextLine());
        System.out.println("Enter the genre:");
        String genre = reader.nextLine();
        System.out.println("Enter the publication year:");
        int py = Integer.parseInt(reader.nextLine());
        System.out.println("Enter the publisher:");
        String pub = reader.nextLine();
        System.out.println("Enter ISBN:");
        long isbn = reader.nextLong();
        return new Comic(title, pn, genre, py, pub, isbn);
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) { /* ignored */}
        }
    }
}
