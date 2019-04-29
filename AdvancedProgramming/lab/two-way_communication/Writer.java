import java.util.*;
import java.net.*;
import java.io.*;

public class Writer implements Runnable {
  private Socket socket;

  public Writer(Socket s) {
    this.socket = s;
  }

  public void run() {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = null;
    try {
      out = new PrintWriter(this.socket.getOutputStream(), true);
      String line = "";
      while(!(line = sc.nextLine()).equals("END")) {
        out.write(line);
      }

    } catch (Exception e) {

    } finally {
      sc.close();
      out.close();
    }
  }
}
