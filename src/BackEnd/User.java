package BackEnd;

/**
 * Created by lucas on 04/05/2014.
 */
public class User {
    private int id;
    private String mail;
    private Boolean isManager;

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public User(int id, String mail, Boolean isManager) {
        this.id = id;
        this.mail = mail;
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return getMail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
