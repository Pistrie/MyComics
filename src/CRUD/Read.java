package CRUD;

import java.sql.*;

public class Read {
    private Connection conn;
    private String filter;

    public Read(Connection conn, String filter) {
        this.conn = conn;
        this.filter = filter;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // prepare statement
            myStmt = conn.prepareStatement("""
                SELECT *
                FROM comics
                WHERE title = ?
                OR ? IS NULL
                """);

            // set parameters
            System.out.println("This is where the user would type the filter");
            if (filter.equals("")) {
                myStmt.setNull(1, Types.NVARCHAR);
                myStmt.setNull(2, Types.NVARCHAR);
            } else {
                myStmt.setString(1, this.filter);
                myStmt.setString(2, this.filter);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (myRs != null) {
                try {
                    myRs.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (myStmt != null) {
                try {
                    myStmt.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }
}
