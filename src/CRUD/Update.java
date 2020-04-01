package CRUD;

import java.sql.*;

public class Update {

    public Update(Connection conn, int newString, int oldString) {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = conn.prepareStatement("""
                UPDATE comics_copy
                SET publication_number = ?
                WHERE publication_number = ?;
                """);

            // set parameters
            System.out.println("This is where the user would type the filter");
            myStmt.setInt(1, newString);
            myStmt.setInt(2, oldString);

            // execute sql query
            myStmt.executeUpdate();
            System.out.println("DB updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (myStmt != null) {
                try {
                    myStmt.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }
}