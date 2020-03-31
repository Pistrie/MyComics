import java.sql.*;
import java.util.Scanner;

public class ComicLibrary {

    public ComicLibrary() {
        Connection conn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        Scanner reader = null;
        try {
            // get connection
            String connectionUrl = "jdbc:mysql://localhost:3306/comics";
            conn = DriverManager.getConnection(connectionUrl, "root", "rootpassword");

            // prepare statement
            myStmt = conn.prepareStatement("""
            SELECT *
            FROM comics
            WHERE title = ?
            OR ? IS NULL
            """);

            // set parameters
            System.out.print("Enter the name you want to filter on. Leave this empty if you don't want to filter: ");
            reader = new Scanner(System.in);
            String filter = reader.nextLine();
            if (filter.equals("")) {
                myStmt.setNull(1, Types.NVARCHAR);
                myStmt.setNull(2, Types.NVARCHAR);
            } else {
                myStmt.setString(1, filter);
                myStmt.setString(2, filter);
            }

            // execute sql query
            myRs = myStmt.executeQuery();

            // display result set
            while (myRs.next()) {
                System.out.println(myRs.getString("title"));
                System.out.println(myRs.getString("publication_number"));
                System.out.println(myRs.getString("genre"));
                System.out.println(myRs.getString("publication_year"));
                System.out.println(myRs.getString("publisher"));
                System.out.println(myRs.getString("isbn"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void display(ResultSet myRs) {
    }
}
