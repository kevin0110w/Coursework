import java.net.*;
import java.util.*;
import java.io.*;

public class Server2 {
  private static final int PORT = 8765;
  private static ServerSocket socket;
  public static void main(String[] args) {
     // ServerSocket socket = null;
     // Socket client = null;
     // BufferedReader in = null;
     // PrintWriter out = null;

    try {
      socket = new ServerSocket(PORT);
      while (true) {
        new Handler(socket.accept()).start();
      }
    } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
        }
      }
    }


  public static class Handler extends Thread {
    private Socket client;
    public Handler(Socket socket) {
      this.client = socket;
    }
    public void run() {
      try {
      BufferedReader  in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter  out = new PrintWriter(client.getOutputStream(), true);
      String password = "password";
      while (true) {
        out.println(password);
        String message = in.readLine();
        if (!(message.equals(password))) {
          break;
        }
        String question = "How old are you?";
        out.println(question);
        String answer = in.readLine();
        System.out.println(answer);
        Thread.sleep(5000);
      }} catch (InterruptedException e) {

      } catch (IOException e) {}
       finally {
        try {
          this.client.close();
        } catch (IOException e) {}
      }
    }
  }
}
