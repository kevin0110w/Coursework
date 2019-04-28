import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) {
    Socket client = null;
    BufferedReader in = null;
    PrintWriter out = null;
    Scanner s = null;
    try {
      client = new Socket("127.0.0.1", 8765);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);
      s = new Scanner(System.in);
      while (true) {
        System.out.println("Please type an option followed by a coursename on a new line");
        String option = s.nextLine();
        out.println(option);
        String course = s.nextLine();
        out.println(course);
        String result = in.readLine();
        System.out.println(option + ": " + course + ": " + result);
      }
    } catch (Exception e) {

    } finally {
      try {
        client.close();
        in.close();
        s.close();
        out.close();
      } catch (Exception e) {

      }
    }
  }
}
