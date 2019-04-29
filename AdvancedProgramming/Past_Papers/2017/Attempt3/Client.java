import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) {
    Socket client = null;
    Scanner s = new Scanner(System.in);
    PrintWriter out = null;
    BufferedReader in = null;
    String password = "";
    try {
      client = new Socket("127.0.0.1", 8765);
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      password = in.readLine();
      boolean correct = false;
      while (!correct) {
      System.out.println("Please enter a password");
      String input = s.nextLine();
      if (input.equals(password)) {
        correct = true;
        while (correct) {
          String question = in.readLine();
          System.out.println(question);
          System.out.println("please type an answer");
          String answer = s.nextLine();
          out.println(answer);
          System.out.println("Please type a comment");
          String comment = s.nextLine();
          out.println(comment);
        }
      }
    }
    } catch (Exception e) {

    } finally {
        try {
          s.close();
          in.close();
          out.close();
          client.close();
  } catch (Exception e) {
    }
  }
}
}
