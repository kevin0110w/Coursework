import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
  public static void main(String[] args) {
  Robot r = new Robot();
  ServerSocket socket = null;
  Socket client = null;
  BufferedReader in = null;
  PrintWriter out = null;
  try {
    socket = new ServerSocket(8765);
    client = socket.accept();
    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    out = new PrintWriter(client.getOutputStream(), true);
    while (true) {
      String question = in.readLine();
      String answer = r.askQuestion(question);
      out.println(answer);
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
