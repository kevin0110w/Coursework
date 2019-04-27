import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
  private static int PORT;
  private static String IP;

  public static void main(String[] args) {
    PORT = 8765;
    IP = "127.0.0.1";
    Socket client = null;
    PrintWriter out = null;
    BufferedReader in = null;
    Scanner s = null;
    try {
      client = new Socket(IP, PORT);
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      s = new Scanner(System.in);
      String message = "";
      while (true) {
        do {
        System.out.println("Please enter the password");
        String password = s.nextLine();
        out.println(password);
        message = in.readLine();
      } while (message.contains("Incorrect"));
        System.out.println("answer or message?");
        String command = s.nextLine();
        out.println(command);
        System.out.println("input?");
        String input = s.nextLine();
        out.println(input);
      }
    } catch (Exception e) {

    } finally {
      try {
        client.close();
        out.close();
        in.close();
        s.close();
      } catch (Exception e) {

      }
    }
  }
}
