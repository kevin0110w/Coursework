import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;

public class Q4 {
  private ArrayList<Person> phonebook;

  public Q4() {
      this.phonebook = new ArrayList<Person>();
  }

  public void read(String file) {
    Scanner reader = null;
    String line = "";
    try {
      reader = new Scanner(new File(file));
      while(reader.hasNextLine()) {
        line = reader.nextLine();
        if (!(line.equals(""))) {
        String[] parts = line.split(": ");
        this.phonebook.add(new Person(parts[0], parts[1]));
      }
    }
  } catch (Exception e) {
    }
    Collections.sort(this.phonebook);
  }

  public void write() {
    FileWriter out = null;
    String output = "";
    for (Person person : this.phonebook) {
      output = output + person + "\n";
    }
    try {
      out = new FileWriter(new File("phonebook.txt"));
      out.write(output);
    } catch (Exception e) {

    } finally {
      try {
        out.close();
      } catch (Exception t) {

      }
    }
  }

  public class Person implements Comparable<Person> {
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

    public String toString() {
      return this.name + ": " + this.phone;
    }

    @Override
    public int compareTo(Person other){
      int number = 0;
      if ((int)this.getName().charAt(0) < (int)other.getName().charAt(0)) {
        number = -1;
      } else if (this.getName().charAt(0) == other.getName().charAt(0) && this.getName().charAt(1) < other.getName().charAt(1)) {
        number = -1;
      } else {
        number = 1;
      }
      return number;
    }
  }

  public static void main(String[] args){
    Q4 q4 = new Q4();
    q4.read("phone.txt");
    q4.write();
  }
}
