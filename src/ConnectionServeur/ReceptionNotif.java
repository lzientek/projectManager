package ConnectionServeur;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lucas on 09/05/2014.
 */


/**
 * Created by lucas on 05/05/2014.
 */
public class ReceptionNotif implements Runnable {

    private BufferedReader in;
    private String message = null;

    public ReceptionNotif(BufferedReader in) {

        this.in = in;
    }

    public void run() {

        while (true) {
            try {

                message = in.readLine();
                System.out.println("Le serveur vous dit :" + message);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}


