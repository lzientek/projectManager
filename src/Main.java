import FrontEnd.Login;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName(
                    com.mysql.jdbc.Driver.class.getName());

            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

        } catch (Exception ex) {
            System.out.println("Can’t load the Driver or look and feel");
        }

        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        Login login = new Login();
                        login.setVisible(true);
                    }
                }
        );
    }
}