package DataBase;

import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.ProjectTask;
import BackEnd.User;
import DataBase.Interface.UserDao;
import com.sun.deploy.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public class JdbcUserDao extends JdbcDao implements UserDao {
    @Override
    public Boolean connectUser(LocalUser user) {
        try {
            String sql1 =
                    "SELECT COUNT (*) AS nbResult FROM  users WHERE mail=? && pass=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, user.getMail());
            pstmt.setString(2, user.getPassword());

            ResultSet result = pstmt.executeQuery();

            result.next();

            if (result.getInt(1) == 1)    //TODO: a tester
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean registerUser(LocalUser user) {
        return null;
    }

    @Override
    public User loadUserById(int id) {
        try {
            String sql1 =
                    "SELECT * FROM  users WHERE id=?";
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
