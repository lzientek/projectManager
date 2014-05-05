package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Reception implements Runnable {
    private PrintWriter out;

    private BufferedReader in;
    private String message = null, login = null;

    public Reception(BufferedReader in, PrintWriter out,
                     String login) {

        this.in = in;
        this.login = login;
        this.out = out;
    }

    public void run() {

        while (true) {
            try {

                message = in.readLine();
                out.println(message);
                out.flush();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}