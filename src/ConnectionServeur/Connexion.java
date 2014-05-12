package ConnectionServeur;

/**
 * Created by lucas on 05/05/2014.
 */


import BackEnd.StockageUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connexion implements Runnable {

    private Socket socket = null;
    public static Thread t2;
    public static String login = null, pass = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private boolean connect = false;


    public Connexion(Socket s) {
        socket = s;
    }

    public Socket getSocket() {
        return socket;
    }

    public void run() {

        try {

            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reponse;

            while (!connect) {
                reponse = in.readLine();
                if (reponse.equals("connecte")) {
                    connect = true;
                    out.println("ok");
                    out.flush();
                    new NotifServeur(socket);
                } else {
                    System.err.println("erreur de connexion");
                }

            }


        } catch (IOException e) {

            System.err.println("Le serveur ne répond plus ");
        }
    }

}

