package Classes;

/**
 * Created by lucas on 05/05/2014.
 */

import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private String login = "zero", mail = null;
    public boolean authentifier = false;
    public Thread t2;

    public Authentification(Socket s) {
        socket = s;
    }

    public void run() {

        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            out.println("authId");
            out.flush();
            login = in.readLine();

            out.println("authMail");
            out.flush();
            mail = in.readLine();

            out.println("connecte");

            t2 = new Thread(new Notification_ClientServeur(socket, login));
            t2.start();

        } catch (IOException e) {
            out.println("erreur");
            out.flush();
            System.err.println(login + " ne répond pas !");
        }
    }


}