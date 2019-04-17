import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 8765;
  public static void main(String[] args) {
    Socket s = null;
    PrintWriter out = null;
    BufferedReader in = null;
    try {
      s = new Socket(IP, PORT);
      out = new PrintWriter(s.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      // Loop forever
      while (true) {
        // Wait for the user to type a command
        String message = System.console().readLine();
        // Send this command to the server
        out.println(message);
        // await a response
        message = in.readLine();
        // if its null, then the server has gone
        if (message == null) {
          break;
        }
        // Display the message
        System.out.println(message);
        // Send back a response
        // String response = System.console().readLine();
        // out.println(response);
      }
      // Thread readThread = new Thread(new Reader(s));
      // Thread writeThread = new Thread(new Writer(s));
      // readThread.start();
      // writeThread.start();
      // readThread.join();
      // writeThread.join();
    }
    //  catch (InterruptedException f) {
    // }
     catch (IOException e) {
    } finally {
      try {
        s.close();
        in.close();
        out.close();
      } catch (IOException e) {

      }
    }
  }
}
