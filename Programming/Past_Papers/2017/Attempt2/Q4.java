import java.util.*;
import java.io.*;

public class Q4 {
  public static ArrayList<Person> read(String file) {
    ArrayList<Person> book = new ArrayList<Person>();
    File f = null;
    FileReader reader = null;
    Scanner s = null;
    try {
      f = new File(file);
      reader = new FileReader(f);
      s = new Scanner(reader);
      String line = "";
      while (s.hasNextLine()) {
        line = s.nextLine();
        if (!(line.equals(""))) {
        String[] parts = line.split(": ");
        book.add(new Person(parts[0], parts[1]));
        }
      }
    } catch (Exception e) {

    }
    finally {
      try {
        s.close();
        reader.close();
      } catch (Exception e) {

      }
    }
    return book;
  }

  public static void write(ArrayList<Person> book) {
    PrintWriter pw = null;
    String line = "";
    try {
      pw = new PrintWriter("phonebook.txt");
    for (Person p : book) {
     line = line + String.format("%-40s, %-12s", p.getName(), p.getPhone()) + "\n";
    }
    pw.write(line);
  } catch (Exception e) {

  } finally {
    try {
      pw.close();
    }catch (Exception e) {
    }
  }
}

  public static void main(String[] args) {
    ArrayList<Person> book = new ArrayList<Person>();
    book = read("phone.txt");
    Collections.sort(book);
    write(book);
  }

  public static class Person implements Comparable<Person> {
    private String name;
    private String phone;
    public Person(String name, String phone) {
      this.name = name;
      this.phone = phone;
    }

    public String getName() {
      return this.name;
    }

    public String getPhone() {
      return this.phone;
    }

    @Override
    public int compareTo(Person other) {
      if (this.getName().charAt(0) < other.getName().charAt(0)) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  // public static class PhoneBook {
  //   private ArrayList<Person> phonebook;
  //   public PhoneBook() {
  //     this.phonebook = new ArrayList<Person>();
  //   }
  //
  //   public void addContact(Person p) {
  //     this.phonebook.add(p);
  //   }
  // }
}
