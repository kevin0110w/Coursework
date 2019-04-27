import java.net.*;
import java.io.*;
import java.util.Random;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.ArrayList;

/*
A client will connect to create a serversocket object.
The server will then loop indefintely and send randomly chosen
quotes every 5 seconds
*/
public class QuotesServer2 {
  private static int PORT = 8765;

  public static void main(String[] args) {
    ServerSocket listener = null;
    Socket client = null;
    Random random = new Random();
    ArrayList<String> quotes = new ArrayList<String>();
    quotes = QuoteLoader.loadQuotes("quotes.txt");
    try {
      listener = new ServerSocket(PORT);
      client = listener.accept();
      // System.out.println("Client has arrived");
      // OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
      // Scanner textInput = new Scanner(System.in);
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      while(true) {
        int randomNum = random.nextInt(20);
        String line = quotes.get(randomNum);
        out.println(line);
        // if (line.equals("")) {
        //   break;
        // }
        // os.write(line + '\n');
        // os.flush();
        Thread.sleep(5000);
      }
    } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      finally {
        try {
          client.close();
          listener.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
  }
}
