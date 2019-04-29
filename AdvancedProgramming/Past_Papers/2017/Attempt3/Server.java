import java.util.*;
import java.io.*;
import java.net.*;


public class Server {
  public static void main(String[] args) {
    String password = "password";
    ServerSocket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;
    Socket client = null;
    try {
      socket = new ServerSocket(8765);
      client = socket.accept();
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);
        out.println(password);
        while (true) {
        String question = "question";
        out.println(question);
        String answer = in.readLine();
        System.out.println(Integer.parseInt(answer));
        String comment = in.readLine();
        System.out.println(comment);
      }
    } catch (Exception e) {

    } finally {
      try {
        in.close();
        out.close();
        socket.close();
        client.close();
      } catch (Exception e) {

      }
    }
  }
}
