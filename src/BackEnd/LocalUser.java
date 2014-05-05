package BackEnd;

/**
 * Created by lucas on 04/05/2014.
 */
public class LocalUser extends User {
    private String password = "";

    public LocalUser(int id, String mail, Boolean isManager) {
        super(id, mail, isManager);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
