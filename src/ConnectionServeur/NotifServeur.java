package ConnectionServeur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lucas on 05/05/2014.
 */
public class NotifServeur implements Runnable {


    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Scanner sc;
    private Thread t3, t4;

    public NotifServeur(Socket s) {
        socket = s;
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sc = new Scanner(System.in);

            Thread t4 = new Thread(new Emission(out));
            t4.start();
            Thread t3 = new Thread(new Reception(in));
            t3.start();


        } catch (IOException e) {
            System.err.println("Le serveur distant s'est déconnecté !");
        }
    }

}

