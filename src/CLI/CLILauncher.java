package CLI;


import BackEnd.LocalUser;
import BackEnd.StockageUser;
import DataBase.JdbcUserDao;

import java.util.Scanner;

/**
 * Created by lucas on 04/05/2014.
 */
public class CLILauncher {
    public static void main(String[] args) {
        System.out.println("Project Manager CLI");
        Scanner sc = new Scanner(System.in);
        LocalUser localUser = null;
        String s = sc.nextLine();
        if (s.equals("connect")) {
            System.out.println("Connect mail puis pass:");
            String m = sc.nextLine();
            String p = sc.nextLine();

            try {
                localUser = new JdbcUserDao().connectUser(m, p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("mail:");
            String m = sc.nextLine();
            String p = sc.nextLine();
            try {
                new JdbcUserDao().createUser(m, p, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (localUser != null) {
            StockageUser.user = localUser;

            System.out.println("1:add a project");
            System.out.println("2:modify a project");
            String line = sc.nextLine();
            if (line.equals("1"))
                Command.addProject();
            if (line.equals("2"))
                Command.modifyProject();
        }
    }
}
