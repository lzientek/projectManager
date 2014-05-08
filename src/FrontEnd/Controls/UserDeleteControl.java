package FrontEnd.Controls;

import BackEnd.User;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lucas on 08/05/2014.
 */
public class UserDeleteControl extends JPanel {
    private User user;

    public UserDeleteControl(User user) {
        this.user = user;
        setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
        setLayout(new FlowLayout());
        add(new JLabel(user.getMail()));
    }
}
