import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class StudentGradeArray {
  private String[] matrics;
  private String[] grades;
  private Scanner scanner;
  private String file;

  public StudentGradeArray() {
    this.matrics = new String[200];
    this.grades = new String[200];
  }

  public void read(String file) {
    File files = new File(file);
    Scanner scanner = null;
    String line = "";
    int n = 0;
    try {
      scanner = new Scanner(files);
    while (scanner.hasNextLine()) {
      line = scanner.nextLine();
      String[] parts = line.split(" ");
      this.matrics[n] = parts[0];
      this.grades[n] = parts[1];
      n++;
    }
  } catch (FileNotFoundException e) {

  }
}

  public void createFile() {
    String fileName = "grades.txt";
    File file = new File(fileName);
    FileWriter out = null;
    String grades = "";
    int n = 0;
    Random random = new Random();
    try {
      out = new FileWriter(file);

    while (n < 200) {
      int number = random.nextInt(8999999) + 1000000;
      String matric = 0 + Integer.toString(number);
      int g = random.nextInt(5) + 1;
      int charac = random.nextInt(5) + 65;
      String grade =  ((char) charac) + Integer.toString(g);
      grades = grades + matric + " " + grade + "\n";
      n++;
    }
    out.write(grades);
  } catch (IOException e) {

  } finally {
    try {
      out.close();
    } catch (IOException e) {

    }
  }
}

  public static void main(String[] args) {
    StudentGradeArray s = new StudentGradeArray();
    s.createFile();
    s.read("grades.txt");
    StudentGrade[] grades = new StudentGrade[200];
    for (int i = 0; i < grades.length; i++) {
      grades[i] = new StudentGrade(s.matrics[i], s.grades[i]);
    }
    Arrays.sort(grades);
    for (StudentGrade ss : grades) {
      System.out.println(ss);
    }
  }
}
