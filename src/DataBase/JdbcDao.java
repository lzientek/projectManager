package DataBase;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lucas on 04/05/2014.
 */
public abstract class JdbcDao {

    protected java.sql.Connection connection;

    public void connect() throws Exception {
        try {
            //TODO:changer les parametres!!!
            connection = DriverManager.getConnection("jdbc:mysql://10.11.19.16:3306/javaparadise", "lucas", "supinfo");
        } catch (SQLException e) {
            throw new Exception("Erreur de connection a la base de données!" + e.getMessage());
        }
    }
}
