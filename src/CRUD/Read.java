package CRUD;

public class Read {
    String mysql = """
            SELECT *
            FROM comics
            WHERE title = :title
            OR title = null
            """;
}
