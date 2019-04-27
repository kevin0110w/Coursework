import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.InputStreamReader;

public class QuotesClient3 {
  private static int PORT = 8765;
  private static String server = "127.0.0.1";

  public static void main(String[] args) {
    Socket socket = null;
    try {
      socket = new Socket(server, PORT);
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  		PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
      Scanner sr = new Scanner(System.in);
      while (true) {
        System.out.println("Type something: ");
        String line = sr.nextLine();
        if (line.equals("")) {
          break;
        }
  			writer.println(line);
  			System.out.println(reader.readLine());
      }
      sr.close();
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
