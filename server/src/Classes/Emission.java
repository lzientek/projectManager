package Classes;

import java.io.BufferedReader;

/**
 * Created by lucas on 05/05/2014.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

    private PrintWriter out;
    private String message = null;
    private Scanner sc = null;

    public Emission(PrintWriter out) {
        this.out = out;
    }


    public void run() {


        while (true) {

            out.println(message);
            out.flush();
        }
    }
}
