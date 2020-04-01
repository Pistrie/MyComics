package CRUD;

import java.sql.*;

public class Update {

    public Update(Connection conn, String newTitle, int newPn, String newGenre, int newPy, String newPub, int newIsbn,
                  String oldTitle, int oldPn, String oldGenre, int oldPy, String oldPub, int oldIsbn) {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = conn.prepareStatement("""
                UPDATE comics_copy
                SET title = ?, publication_number = ?, genre = ?, publication_year = ?, publisher = ?, isbn = ?
                WHERE title = ? AND publication_number = ? AND genre = ? AND publication_year = ?
                AND publisher = ? AND isbn = ?
                """);

            // set parameters
            System.out.println("This is where the user would type the filter");
            myStmt.setString(1, newTitle);
            myStmt.setInt(2, newPn);
            myStmt.setString(3, newGenre);
            myStmt.setInt(4, newPy);
            myStmt.setString(5, newPub);
            myStmt.setInt(6, newIsbn);
            myStmt.setString(7, oldTitle);
            myStmt.setInt(8, oldPn);
            myStmt.setString(9, oldGenre);
            myStmt.setInt(10, oldPy);
            myStmt.setString(11, oldPub);
            myStmt.setInt(12, oldIsbn);

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
        }
    }
}