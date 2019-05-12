import java.util.*;

public class Title {
  private String name, author;
  private int isbn, date;
  private List<LibraryItem> items;

  public Title(String name, String author, int isbn, int date) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.date = date;
    this.items = new ArrayList<LibraryItem>();
  }

  public void addLibraryItem(LibraryItem item) {
    this.items.add(item);
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    String s = "";
    String t = "";
    s = "Book name: " + this.name + "\n Author: " + this.author + "\n ISBN: " + this.isbn + "\n Date: " + this.date + "\n";
    for (LibraryItem i : this.items) {
      t = t + i.toString() + "\n";
    }
    return s + t;
  }
}
