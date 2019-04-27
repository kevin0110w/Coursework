import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.InputStreamReader;

/*
The client will receive a single quote from the server and print it to
the console.
It'll immediately close afterwards
*/
public class QuotesClient {
  private static int PORT = 8765;
  private static String server = "127.0.0.1";

  public static void main(String[] args) {
    Socket socket = null;
    try {
      socket = new Socket(server, PORT);
      Scanner sr = new Scanner(socket.getInputStream());
      while (sr.hasNextLine()) {
        System.out.println(sr.nextLine());
      }
      sr.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
