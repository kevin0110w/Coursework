import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.InputStreamReader;

public class QuotesClient2 {
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
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
