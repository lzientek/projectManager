package DataBase.Interface;

import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.User;

import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public interface UserDao {
    public Boolean createUser(String mail, String pass, Boolean isManager);

    public LocalUser connectUser(String mail, String pass);

    public Boolean registerUser(LocalUser user);

    public User loadUserById(int id);

    public List<User> loadUsers();

    public List<User> loadUserByFromProject(String[] strings);
}
