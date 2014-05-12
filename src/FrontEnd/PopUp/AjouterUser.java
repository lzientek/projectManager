package FrontEnd.PopUp;

import BackEnd.User;
import DataBase.JdbcUserDao;
import FrontEnd.Controls.TitleLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by lucas on 11/05/2014.
 */
public class AjouterUser extends JFrame {
    private JComboBox comboBox;
    private final JButton btnEnregistrer;

    public JButton getBtnEnregistrer() {
        return btnEnregistrer;
    }

    public AjouterUser(List<User> utilisateurAexclure, Boolean aExclure) {

        setTitle("Ajouter un utilisateur");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new TitleLabel("Ajouter un utilisateur", 16);
        getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        btnEnregistrer = new JButton("Ajouter");

        btnEnregistrer.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(btnEnregistrer, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        if (aExclure)
            getjComboBoxFull(utilisateurAexclure);
        else
            getjComboBoxInclure(utilisateurAexclure);
        panel.add(comboBox);
        validate();
        setVisible(true);

    }

    private void getjComboBoxFull(List<User> utilisateurAexclure) {
        Vector<User> listUser = new JdbcUserDao().loadUsers();
        if (listUser != null)
            for (int i = listUser.size() - 1; i >= 0; i--) {
                for (int j = 0; j < utilisateurAexclure.size(); j++) {
                    if (utilisateurAexclure.get(j).getId() == listUser.get(i).getId()) {
                        listUser.remove(i);
                        break;
                    }
                }
            }

        if (listUser != null)
            comboBox = new JComboBox(listUser);
        else comboBox = new JComboBox();
    }

    private void getjComboBoxInclure(List<User> utilisateur) {
        Vector<User> listUser = new Vector<User>();
        for (int i = 0; i < utilisateur.size(); i++) {
            listUser.add(utilisateur.get(i));
        }

        comboBox = new JComboBox(listUser);
    }

    public User getSelectedItem() {
        return (User) comboBox.getSelectedItem();
    }
}
