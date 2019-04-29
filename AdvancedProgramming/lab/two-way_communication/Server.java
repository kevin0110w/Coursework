import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) {
    ServerSocket s = null;
    Socket client =  null;
    try {
      s = new ServerSocket(8765);
      client = s.accept();
      Thread readThread = new Thread(new Reader(client));
      Thread writeThread = new Thread(new Writer(client));
      readThread.start();
      writeThread.start();
      try {
        readThread.join();
        writeThread.join();
      } catch (Exception e) {

      }
    } catch (Exception e) {
    }
    finally { 
    try {
      client.close();
      s.close();
    } catch (Exception e) {

    }
    }
  }
}
