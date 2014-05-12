package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Reception implements Runnable {
    private PrintWriter out;

    private BufferedReader in;
    private String message = null;

    public Reception(BufferedReader in, PrintWriter out) {

        this.in = in;
        this.out = out;
    }

    public void run() {

        while (true) {
            try {

                message = in.readLine();
                out.println(message);
                out.flush();
            } catch (IOException e) {
                System.out.println("deconnecter!");

                e.printStackTrace();
                break;
            }
        }
    }

}