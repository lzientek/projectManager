package FrontEnd.Controls;

import BackEnd.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by lucas on 08/05/2014.
 */
public class UserDeleteControl extends JPanel {
    private final JButton btnSup;
    private User user;


    public UserDeleteControl(User user, ActionListener actionListenerDelete) {
        this.user = user;
        setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
        setLayout(new FlowLayout());
        add(new JLabel(user.getMail()));
        btnSup = new JButton("supprimer");
        btnSup.addActionListener(actionListenerDelete);
        add(btnSup);
    }
}
