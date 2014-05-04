package DataBase;

import sun.rmi.transport.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lucas on 04/05/2014.
 */
public abstract class JdbcDao {

    private java.sql.Connection connection;
    public void connect() throws Exception {
        try {
            //TODO:changer les parametres!!!
            connection = DriverManager.getConnection("jdbc:mysql://10.11.19.16:3306/javaparadise", "lucas", "supinfo");
        } catch (SQLException e) {
           throw new Exception("Erreur de connection a la base de données!");
        }
    }
}
