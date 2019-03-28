package lab.distributed;

import java.util.ArrayList;
import java.io.*;

public class QuoteLoader {
	public static ArrayList<String> loadQuotes(String filename) {
		ArrayList<String> q = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while((line = reader.readLine())!=null) {
				q.add(line);
			}
			reader.close();
			return q;
		}catch(IOException e) {}
		return q;
	}
}
//public class QuoteLoader {
//	private ArrayList<String> quotes;
//	
//	public QuoteLoader() {
//		this.setQuotes(new ArrayList<>());
//	}
//	public void loadQuotes(String filename) {
////	public ArrayList<String> loadQuotes(String filename) {
//		ArrayList<String> q = new ArrayList<String>();
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			String line;
//			while((line = reader.readLine())!=null) {
//				q.add(line);
//			}
//			reader.close();
////			return q;
//		}catch(IOException e) {}
////		return q;
//		this.quotes = q;
//		}
//	
//
//	public static void main(String[] args) {
//		QuoteLoader x = new QuoteLoader();
//		x.loadQuotes("quotes.txt");
//		x.getQuotes().get(0);
//		}
//
//	public ArrayList<String> getQuotes() {
//		return quotes;
//	}
//
//	public void setQuotes(ArrayList<String> quotes) {
//		this.quotes = quotes;
//	}
//	}
