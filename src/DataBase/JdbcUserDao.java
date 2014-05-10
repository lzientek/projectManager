package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BackEnd.LocalUser;
import BackEnd.User;
import DataBase.Interface.UserDao;

import com.sun.deploy.util.StringUtils;

/**
 * Created by lucas on 04/05/2014.
 */
public class JdbcUserDao extends JdbcDao implements UserDao {

    public JdbcUserDao() {
        try {
            connect();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public Boolean createUser(String mail, String pass, Boolean isManager) {
        try {
            String sql1 =
                    "INSERT INTO users (mail,pass,isManager)"
                            + " VALUES (?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, mail);
            pstmt.setString(2, pass);
            pstmt.setInt(3, isManager ? 1 : 0);

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public LocalUser connectUser(String mail, String pass) {
        try {
            String sql1 =
                    "SELECT * FROM  users WHERE mail=? AND pass=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, mail);
            pstmt.setString(2, pass);

            ResultSet result = pstmt.executeQuery();

            if (result.next())
                return new LocalUser(result.getInt("idusers"), result.getString("mail"), result.getInt("isManager") == 1);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean registerUser(LocalUser user) {
        return createUser(
                user.getMail(),
                user.getPassword(),
                user.getIsManager());
    }

    @Override
    public User loadUserById(int id) {
        try {
            String sql1 =
                    "SELECT * FROM  users WHERE idusers=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();
            result.next();
            User user = new User(result.getInt("idusers"),
                    result.getString("mail"),
                    result.getInt("isManager") == 1);

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> loadUserByFromProject(String[] strings) {
        try {
            String inString = StringUtils.join(Arrays.asList(strings), ", ");
            String sql1 =
                    "SELECT * FROM  users WHERE idusers IN (" + inString + ")";
            PreparedStatement pstmt = connection.prepareStatement(sql1);

            ResultSet result = pstmt.executeQuery();

            List<User> userList = new ArrayList<User>();

            while (result.next()) {
                userList.add(new User(
                        result.getInt("idusers"),
                        result.getString("mail"),
                        result.getInt("isManager") == 1));

            }


            return userList;
        } catch (Exception e) {
            return null;
        }
    }
}
