package CRUD;

import java.sql.*;
import Comic.Comic;

public class Update {

    public Update(Connection connection, Comic newComic, Comic oldComic) {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = connection.prepareStatement("""
                UPDATE comics_copy
                SET title = ?, publication_number = ?, genre = ?, publication_year = ?, publisher = ?, isbn = ?
                WHERE title = ? AND publication_number = ? AND genre = ? AND publication_year = ?
                AND publisher = ? AND isbn = ?
                """);

            // set parameters
            System.out.println("This is where the user would type the filter");
            myStmt.setString(1, newComic.getTitle());
            myStmt.setInt(2, newComic.getPublication_number());
            myStmt.setString(3, newComic.getGenre());
            myStmt.setInt(4, newComic.getPublication_year());
            myStmt.setString(5, newComic.getPublisher());
            myStmt.setInt(6, newComic.getIsbn());
            myStmt.setString(7, oldComic.getTitle());
            myStmt.setInt(8, oldComic.getPublication_number());
            myStmt.setString(9, oldComic.getGenre());
            myStmt.setInt(10, oldComic.getPublication_year());
            myStmt.setString(11, oldComic.getPublisher());
            myStmt.setInt(12, oldComic.getIsbn());

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