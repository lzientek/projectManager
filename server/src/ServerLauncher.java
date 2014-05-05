import Classes.AcceptConnexion;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by lucas on 04/05/2014.
 */
public class ServerLauncher {

    public static ServerSocket ss = null;
    public static Thread t;

    public static void main(String[] args) {

        System.out.println("server online!");

        try {
            ss = new ServerSocket(2042);
            System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());

            t = new Thread(new AcceptConnexion(ss));
            t.start();

        } catch (IOException e) {
            System.err.println("Le port " + ss.getLocalPort() + " est déjà utilisé !");
        }
    }
}
