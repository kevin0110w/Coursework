import java.net.*;
import java.io.*;
import java.util.Random;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class QuotesServer3 {
  private static int PORT = 8765;

  public static void main(String[] args) {
    ServerSocket listener = null;
    Socket client = null;
    Random random = new Random();
    ArrayList<String> quotes = new ArrayList<String>();
    quotes = QuoteLoader.loadQuotes("quotes.txt");
    try {
      listener = new ServerSocket(PORT);
      // client = listener.accept();
      // System.out.println("Client has arrived");
      // OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
      // Scanner textInput = new Scanner(System.in);
      // PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      while(true) {
        // int randomNum = random.nextInt(20);
        // String line = quotes.get(randomNum);
        // out.println(line);
        // if (line.equals("")) {
        //   break;
        // }
        // os.write(line + '\n');
        // os.flush();
        // Thread.sleep(5000);
        new Handler(listener.accept(), quotes, random).start();
      }
    }  catch (IOException e) {
        e.printStackTrace();
      }
      finally {
        try {
          // client.close();
          listener.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
  }

  public static class Handler extends Thread {
    private Socket socket;
    private ArrayList<String> quotes = new ArrayList<String>();
    private Random rand;
    public Handler(Socket socket, ArrayList<String> quotes, Random random) {
      this.socket = socket;
      this.quotes = quotes;
      this.rand = random;
    }
    public void run() {
      try {
        System.out.println("New connection started on thread " + this.getName());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        while(true) {
          int randomNumber = this.rand.nextInt(20);
          String line = quotes.get(randomNumber);
          out.println(line);
          Thread.sleep(5000);
        }
      } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            this.socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
