import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
  private static final int PORT = 8765;

  public static void main(String[] args) {
     ServerSocket socket = null;
     Socket client = null;
     BufferedReader in = null;
     PrintWriter out = null;
    try {
      String password = "password";
      socket = new ServerSocket(PORT);
      client = socket.accept();
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);

      while (true) {
        out.println(password);
        String message = in.readLine();
        if (!(message.equals(password))) {
          break;
        }
        String question = "How old are you?";
        out.println(question);
        String answer = in.readLine();
        System.out.println(answer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
        client.close();
        in.close();
        out.close();
      } catch (IOException e) {

      }
    }
  }
}
