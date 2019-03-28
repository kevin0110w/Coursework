package lab.distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class QuoteServer  {
	private final static int socketNumber = 8765;
	private static ServerSocket listener;
	private static Socket client;
	private static ArrayList<String> actualQuotes;
	private static PrintWriter writer;
	private static BufferedReader reader;
	private String line;
	private static Random rand = new Random();
	
	public QuoteServer() {
		
	}

	public static void main(String[] args) throws IOException {
			listener = new ServerSocket(socketNumber);
			client = listener.accept();
			actualQuotes = QuoteLoader.loadQuotes("quotes.txt");
			writer = new PrintWriter(client.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (true) {
					int j = rand.nextInt(actualQuotes.size());
					String line = actualQuotes.get(j);
					writer.print(line);
					if (reader.readLine() == null) {
						break;
					}
					try {
					Thread.sleep(5000);
				}  catch (InterruptedException e) {

				}
			}
				try {
					client.close();
					listener.close();
					reader.close();
					writer.close();
				} catch (IOException e) {
			}
	}
}