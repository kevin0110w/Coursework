package lab.distributed;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class QuoteServer {


	public QuoteServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket client = null;
		QuoteLoader quotes = new QuoteLoader();
		ArrayList<String> actualquotes = new ArrayList<>();
		actualquotes = quotes.loadQuotes("Quotes.txt");
		Scanner reader = null;
		Random rand = new Random();
		try {
			listener = new ServerSocket(8765);
			client = listener.accept();

			OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
			String line = "";
			boolean write = true;
			while (write) {
				for (int i = 0; i < actualquotes.size(); i++) {
					int j = rand.nextInt(actualquotes.size());
					line = actualquotes.get(j);
					
				}
				write = false;
			}
			os.write(line + '\n');
			os.flush();
			client.close();
			listener.close();

		} catch(IOException e) {

		}
	}
}
