import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) {
    Socket listener = null;
    PrintWriter out = null;
    BufferedReader in = null;
    Scanner s = new Scanner(System.in);
    try {
      listener = new Socket("127.0.0.1", 8765);
      out = new PrintWriter(listener.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(listener.getInputStream()));
      while (true) {
        System.out.println("Please ask a question to the robot");
        String question = s.nextLine();
        out.println(question);
        String answer = in.readLine();
        System.out.println("The robot says: ");
        System.out.println(answer);
      }
    } catch (Exception e) {

    } finally {
    try {
     out.close();
     in.close();
     listener.close();
    } catch (Exception e) {

    }
    }
  }
}
