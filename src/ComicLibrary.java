import java.sql.Connection;
import java.sql.DriverManager;

public class ComicLibrary {

    public ComicLibrary() {
        Connection conn = null;
        try {
            // get connection
            String connectionUrl = "jdbc:mysql://localhost:3306/comics";
            conn = DriverManager.getConnection(connectionUrl, "root", "rootpassword");
//            // create statement
//            Statement myStmt = conn.createStatement();
//            // execute sql
//            ResultSet myRs = myStmt.executeQuery("SELECT * FROM comics");
//            // process result set
//            while (myRs.next()) {
//                System.out.println(myRs.getString("title") + ", "
//                        + myRs.getString("publication_number") + ", "
//                        + myRs.getString("isbn"));
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
