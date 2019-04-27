import java.io.*;
import java.net.*;

public class Server {
  private static int PORT;

  public static void main(String[] args) {
    PORT = 8765;
    String password = "password";
    ServerSocket socket = null;
    Socket client = null;
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      socket = new ServerSocket(PORT);
      client = socket.accept();
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      while (true) {
        String command = in.readLine();
        if (!command.equals(password)) {
          String message = "Incorrect message. Please try again";
          out.println(message);
        } else {
          String correct = "correct";
          out.println(correct);
          String request = in.readLine();
          if (request.equals("answer")) {
            int answer = Integer.parseInt(in.readLine());
            System.out.println(answer);
          } else if (request.equals("message")) {
            String message = in.readLine();
            System.out.println(message);
          }
        }
      }
    } catch (Exception e) {

    } finally {
      try {
        socket.close();
        client.close();
        in.close();
        out.close();
      } catch (Exception e) {

      }
    }
  }
}
