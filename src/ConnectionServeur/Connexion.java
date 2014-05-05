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

    public void run() {

        try {

            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (!connect) {

                if (in.readLine() == "authId") {
                    out.println(StockageUser.user.getId());
                    out.flush();
                }
                if (in.readLine() == "authMail") {
                    out.println(StockageUser.user.getMail());
                    out.flush();
                }
                if (in.readLine().equals("connecte")) {
                    connect = true;
                } else {
                    System.err.println("erreur de connexion");
                }

            }

            new NotifServeur(socket);


        } catch (IOException e) {

            System.err.println("Le serveur ne répond plus ");
        }
    }

}

