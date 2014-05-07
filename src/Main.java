import FrontEnd.Login;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName(
                    com.mysql.jdbc.Driver.class.getName());
            try {
                UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Can’t load the Driver");
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}