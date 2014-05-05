package Classes;

/**
 * Created by lucas on 05/05/2014.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class AcceptConnexion implements Runnable {

    private ServerSocket socketserver = null;
    private Socket socket = null;

    public Thread t1;

    public AcceptConnexion(ServerSocket ss) {
        socketserver = ss;
    }

    public void run() {

        try {
            while (true) {

                socket = socketserver.accept();
                System.out.println("Connexion ...");

                t1 = new Thread(new Authentification(socket));
                t1.start();

            }
        } catch (IOException e) {

            System.err.println("Erreur serveur");
        }

    }
}