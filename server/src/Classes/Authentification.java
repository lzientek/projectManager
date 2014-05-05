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

            while (!authentifier) {

                out.println("authId");
                out.flush();
                login = in.readLine();


                out.println("authMail");
                out.flush();
                mail = in.readLine();


            }
            t2 = new Thread(new Notification_ClientServeur(socket, login));
            t2.start();

        } catch (IOException e) {
            out.println("erreur");
            out.flush();
            System.err.println(login + " ne répond pas !");
        }
    }

    private static boolean isValid(String login, String pass) {


        boolean connexion = false;
        try {
            Scanner sc = new Scanner(new File("zero.txt"));


            while (sc.hasNext()) {
                if (sc.nextLine().equals(login + " " + pass)) {
                    connexion = true;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Le fichier n'existe pas !");
        }
        return connexion;

    }

}