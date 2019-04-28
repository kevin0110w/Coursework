import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) {
    ServerSocket socket = null;
    Socket client = null;
    BufferedReader in = null;
    PrintWriter out = null;
    ExamDatabase db = new ExamDatabase();
    try {
      socket = new ServerSocket(8765);
      client = socket.accept();
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);
      while (true) {
        String option = in.readLine();
        String course = in.readLine();
        boolean result = false;
        if (option.equals("SET")) {
         result =  db.paperSet(course);
        } else if (option.equals("CHECKED")) {
          result = db.paperChecked(course);
        }
        out.println(result);
      }
    } catch (Exception e) {
    } finally {
      try {
        in.close();
        out.close();
        client.close();
        socket.close();
      } catch (Exception e) {

      }
    }
  }
}
