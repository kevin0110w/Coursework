import java.net.*;
import java.io.*;
import java.util.*;

public class Reader implements Runnable {
  private Socket socket;
  public Reader(Socket s) {
    this.socket = s;
  }

  public void run() {
    try {
      Scanner sc = new Scanner(this.socket.getInputStream());
      while(sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
      sc.close();
    } catch (IOException e) {

    }
  }
}
