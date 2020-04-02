package CRUD;

import Comic.Comic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public Delete(Connection connection, Comic comic) {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = connection.prepareStatement("""
                DELETE FROM comics_copy
                WHERE title = ? AND publication_number = ? AND genre = ? AND publication_year = ?
                AND publisher = ? AND isbn = ?
                """);

            // set parameters
            myStmt.setString(1, comic.getTitle());
            myStmt.setInt(2, comic.getPublication_number());
            myStmt.setString(3, comic.getGenre());
            myStmt.setInt(4, comic.getPublication_year());
            myStmt.setString(5, comic.getPublisher());
            myStmt.setLong(6, comic.getIsbn());

            // execute sql query
            myStmt.executeUpdate();
            System.out.println("Row deleted successfully");
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
