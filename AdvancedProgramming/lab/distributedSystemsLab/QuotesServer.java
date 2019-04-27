import java.net.*;
import java.io.*;
import java.util.Random;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.ArrayList;

/*
* A client will connect to form a serversocket object. The server will
randomly choose a single quote and send this to the client. 
*/
public class QuotesServer {
  private static int PORT = 8765;

  public static void main(String[] args) {
    ServerSocket listener = null;
    Socket client = null;
    Random random = new Random();
    ArrayList<String> quotes = new ArrayList<String>();
    quotes = QuoteLoader.loadQuotes("quotes.txt");
    try {
      int randomNum = random.nextInt(20);
      listener = new ServerSocket(PORT);
      client = listener.accept();
      // System.out.println("Client has arrived");
      OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
      Scanner textInput = new Scanner(System.in);
      while(true) {
        String line = quotes.get(randomNum);
        // if (line.equals("")) {
        //   break;
        // }
        os.write(line + '\n');
        os.flush();
        break;
      }
      textInput.close();
      client.close();
      listener.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
