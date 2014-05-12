package ConnectionServeur;

import BackEnd.StockageUser;
import FrontEnd.AppFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by lucas on 05/05/2014.
 */
public class NotifServeur {


    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private AppFrame frame;


    private static NotifServeur notifServeur;
    public static Boolean isOnline = false;

    public static NotifServeur getNotifServeur() {
        return notifServeur;
    }

    public NotifServeur(Socket s) {
        socket = s;
        notifServeur = this;
        isOnline = true;
        reception();
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Le serveur distant s'est déconnecté !");
        }
    }

    public void emission(String message) {
        Thread t = new Thread(new EmissionNotif(out, message));
        t.start();
    }

    public void reception() {
        Thread t = new Thread(new ReceptionNotif(in, frame));
        t.start();
    }

    public AppFrame getFrame() {
        return frame;
    }

    public void setFrame(AppFrame frame) {
        this.frame = frame;
    }
}

