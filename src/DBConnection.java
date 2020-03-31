import java.sql.*;

public class DBConnection {

    public DBConnection() {
        try {
            // get connection
            String connectionUrl = "jdbc:mysql://localhost:3306/comics";
            Connection con = DriverManager.getConnection(connectionUrl, "root", "rootpassword");
            // create statement
            Statement myStmt = con.createStatement();
            // execute sql
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM comics");
            // process result set
            while (myRs.next()) {
                System.out.println(myRs.getString("title") + ", " + myRs.getString("isbn"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
