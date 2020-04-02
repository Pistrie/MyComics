import CRUD.Read;
import CRUD.Update;

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
                    case "1" -> System.out.println("Not yet supported");
                    case "2" -> System.out.println("noted");
                    case "3" -> System.out.println("noted");
                    case "4" -> System.out.println("Not yet supported");
                    case "5" -> running = false;
                    default -> System.out.println("Please enter a valid option.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
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
