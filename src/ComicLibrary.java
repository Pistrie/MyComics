import CRUD.Read;
import CRUD.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComicLibrary {
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rootpassword";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/comics";

    private static Connection connection = null;
    static{
        try {
            Class.forName(DB_DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Read read = new Read(connection, "Dirkjan");
    Update update = new Update(connection, 8, 2);

    public static Connection getConnection(){
        return connection;
    }
}
