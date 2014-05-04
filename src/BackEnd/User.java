package BackEnd;

/**
 * Created by lucas on 04/05/2014.
 */
public class User {
    private int id;
    private String mail;

    public User(int id, String mail) {
        this.id = id;
        this.mail = mail;
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
