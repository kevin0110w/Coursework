package lab.distributed;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;

public class OneCharClient {

	public OneCharClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.56.1", 8765);
			
			InputStreamReader sr = new InputStreamReader(s.getInputStream());
			
			int c = sr.read();
			System.out.println((char) c);
			sr.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
