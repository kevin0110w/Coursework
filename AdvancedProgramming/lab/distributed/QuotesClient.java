package lab.distributed;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class QuotesClient {
	
	public QuotesClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("130.209.157.54", 8765);
			Scanner reader = new Scanner(s.getInputStream());
			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
				break;
			}
			reader.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
