package ConnectionServeur;

import FrontEnd.AppFrame;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lucas on 09/05/2014.
 */


/**
 * Created by lucas on 05/05/2014.
 */
public class ReceptionNotif implements Runnable {

    private final AppFrame frame;
    private BufferedReader in;
    private String message = null;

    public ReceptionNotif(BufferedReader in, AppFrame frame) {
        this.frame = frame;
        this.in = in;
    }

    public void run() {

        while (true) {
            try {

                message = in.readLine();
                if (message.equals("mp") || message.equals("np") || message.equals("nt") || message.equals("mt"))
                    frame.reload();


            } catch (IOException e) {

                e.printStackTrace();

                break;
            }
        }
    }
}


