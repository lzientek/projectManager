package Classes;

/**
 * Created by lucas on 05/05/2014.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Authentification implements Runnable {

    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    public boolean authentifier = false;
    public Thread t2;

    public Authentification(Socket s) {
        socket = s;
    }

    public void run() {

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            out.println("connecte");
            out.flush();
            String reponse;
            do {
                out.println("connecte");
                out.flush();
                reponse = in.readLine();
            } while (!reponse.equals("ok"));
            t2 = new Thread(new Notification_ClientServeur(socket));
            t2.start();

        } catch (IOException e) {
            out.println("erreur");
            out.flush();
            System.err.println(" ne répond pas !");
        }
    }


}