import FrontEnd.UserWindow;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName(
                    com.mysql.jdbc.Driver.class.getName());
        } catch (ClassNotFoundException ex) {
            System.out.println("Can’t load the Driver");
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UserWindow frame = new UserWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}