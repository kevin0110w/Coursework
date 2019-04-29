import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) {
    Socket client = null;
    try {
      client = new Socket("127.0.0.1", 8765);
      Thread readThread = new Thread(new Reader(client));
      Thread writeThread = new Thread(new Writer(client));
      readThread.start();
      writeThread.start();
        readThread.join();
        writeThread.join();
    } catch (Exception e) {

    } finally {
      try {
        client.close();
      } catch (Exception e) {

      }
    }
  }
}
