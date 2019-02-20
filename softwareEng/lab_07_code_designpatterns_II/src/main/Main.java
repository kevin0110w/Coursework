package main;

import observer.RSSReader;
import observer.RSSFeed;
import immutable.Magazine;
import proxy.Journal;
import proxy.JournalLightWeight;
import readOnlyInterface.Book;
import readOnlyInterface.ReadOnlyBook;

public class Main {

	public static void main(String[] args) {
		//  Observer
		RSSReader reader = new RSSReader();
		RSSFeed feed1 = new RSSFeed();
		RSSFeed feed2 = new RSSFeed();
		
		reader.add(feed1);
		reader.add(feed2);
		
		//  Read Only Pattern
		Book book = new Book("Lord of the Rings", "J.R.R. Tolkien", "Some Date", 1356, 12, "The Best Book Ever Written");
		ReadOnlyBook readOnlyBook = book;
		
		//  If you store the book by variable type ReadOnlyBook (which is our interface defined in ReadOnlyBook) then
		//  that variable will only make the read only interface visible.
		//  readOnlyBook.setTitle("Lord of the Dance");
		
		//  The Book object remains unchanged.
		book.setPublicationDate("The Right Date");
		
		//  Immutable Magazine
		Magazine immutableMagazine = new Magazine("Runners' World", "Editor", "Some Date", 41244, 67, "A magazine for runners.");
		
		//  Calling the settings won't change our magazine object.
		immutableMagazine.setEditor("Different Editor");
		
		//  Any changes to the immutable object will be returned as a new object.
		Magazine newMagazine = immutableMagazine.setISBN(3578);
		
		//  Proxy class means we can keep a local copy (lightweight process, also called proxy class)
		//  of an object that is accessed usign a heavyweigh process (like a database or server call)
		
		//  Using the proxy pattern, we can store these using the Interface Journal.  Then, if both lightweight and heavyweight
		//  object implement this interface, the developer can work with both seamlessly without needing to know which
		//  object is under the covers.
		Journal journal = new JournalLightWeight();

	}

}
