package ConnectionServeur;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by lucas on 05/05/2014.
 */
public class EmissionNotif implements Runnable {

    private PrintWriter out;
    private String message = null;

    public EmissionNotif(PrintWriter out, String message) {
        this.out = out;
        this.message = message;
    }


    public void run() {


        out.println(message);
        out.flush();
    }
}
