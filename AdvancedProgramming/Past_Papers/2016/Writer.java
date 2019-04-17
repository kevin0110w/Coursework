import java.net.*;
import java.io.*;
import java.util.*;

public class Writer implements Runnable {
  private Socket socket;
  public Writer(Socket s) {
    this.socket = s;
  }
  public void run() {
    try {
      Scanner sc = new Scanner(System.in);
      OutputStreamWriter os = new OutputStreamWriter(this.socket.getOutputStream());
      String line;
      while(!(line = sc.nextLine()).equals("END")) {
        os.write(line + '\n');
        os.flush();
      }
      sc.close();
      os.close();
    } catch (IOException e) {

    }
  }
}
