import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
  private static final int PORT = 8765;
  private static final String IP = "127.0.0.1";

  public static void main(String[] args) {
    Scanner scanner = null;
    Socket client = null;
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      scanner = new Scanner(System.in);
      client = new Socket(IP, PORT);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);

      while (true) {
        String password = in.readLine();
        System.out.println("Please enter the password: ");
        String passwordInput = scanner.nextLine();
        if (!(passwordInput.equals(password))) {
          System.out.println("Incorrect Password. Goodbye!");
          break;
        }
        out.println(passwordInput);
        String question = in.readLine();
        System.out.println(question);
        System.out.println("Please enter your answer: ");
        Integer answer = Integer.parseInt(scanner.nextLine());
        out.println(answer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
    try {
      scanner.close();
      in.close();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
}
