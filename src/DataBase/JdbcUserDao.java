package DataBase;

import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.ProjectTask;
import BackEnd.User;
import DataBase.Interface.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            PreparedStatement pstmt = connection.prepareStatement( sql1 );
            pstmt.setString(1, user.getMail());
            pstmt.setString(2, user.getPassword());

            ResultSet result = pstmt.executeQuery();

            ProjectTask taskToReturn;

            result.next();

            if(result.getInt(1) == 1)    //TODO: a tester
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
    public List<User> loadUserFromProject(Project project) {
        try {
            String sql1 =
                    "SELECT COUNT (*) AS nbResult FROM  users WHERE id=? && pass=?";  //TODO: il va falloir un join!
            PreparedStatement pstmt = connection.prepareStatement( sql1 );
            pstmt.setInt(1, project.getId());

            ResultSet result = pstmt.executeQuery();

            List<User> userList = new ArrayList<User>();

            while(result.next()){
                //TODO:implémenter

            }


            return userList;
        } catch (Exception e) {
            return null;
        }
    }
}
