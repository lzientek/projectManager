package DataBase;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lucas on 04/05/2014.
 */
public abstract class JdbcDao {

    protected java.sql.Connection connection;

    protected void connect() throws Exception {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2", "root", "root");
        } catch (SQLException e) {
            throw new Exception("Erreur de connection a la base de données!" + e.getMessage());
        }
    }
}
