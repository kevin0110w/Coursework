import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  public static void main(String[] args) {
    StudentDatabase db = new StudentDatabase();
    int PORT = 8765;
    ServerSocket socket = null;
    Socket client = null;
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      socket = new ServerSocket(PORT);
      client = socket.accept();
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);
      while (true) {
        String command = in.readLine();
        String matric = in.readLine();
        String result = "";
        if (command.contains("name")) {
          result = db.getName(matric);
          System.out.println(result);
        } else if (command.contains("programme")) {
          result = db.getProgramme(matric);
        }
        out.println(command + ": " + result);
      }
    } catch (Exception e) {

    } finally {
      try {
        out.close();
        in.close();
        socket.close();
        client.close();
      } catch (Exception e) {
      }
    }
  }
}
