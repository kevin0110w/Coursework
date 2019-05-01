import java.util.*;
import java.io.*;

public class Q5 {
    private String[] matrics;
    private String[] grades;
    public Q5() {
      matrics = new String[200];
      grades = new String[200];
    }

    public String[] getGrades() {
      return grades;
    }

    public String[] getMatrics() {
      return matrics;
    }


  public void read(String filename) {
  File f = null;
  FileReader fr = null;
  Scanner s = null;
  try {
    f = new File(filename);
    fr = new FileReader(f);
    s = new Scanner(fr);
    String line = "";
    int i = 0;
    while (s.hasNextLine()) {
      line = s.nextLine();
      String[] parts = line.split(" ");
      this.matrics[i] = parts[0];
      this.grades[i] = parts[1];
      i++;
    }
  } catch (Exception e) {

  } finally {
    try {
      fr.close();
      s.close();
    } catch(Exception e) {

    }
  }
  }
  public boolean greater(String grade1, String grade2) {
    boolean greaterstill = true;
    if (grade1.charAt(0) < grade2.charAt(0)) {
      greaterstill = true;
    } else if (grade1.charAt(0) == grade2.charAt(0) && (int)grade1.charAt(1) < (int)grade2.charAt(1)) {
      greaterstill = true;
    } else {
      greaterstill = false;
    }
    return greaterstill;
  }



public static void main(String[] args) {
  Q5 t = new Q5();
  int temp = 0;
  t.read("grades.txt");
  // String[] grades = new Student[200];
  // String[] matrics = new Student[200];
  for (int i = 0; i < t.getGrades().length; i++) {
    if (t.greater(t.getGrades()[i], t.getGrades()[temp])) {
      temp = i;
    }
  }
  System.out.println(t.getMatrics()[temp] + ": " + t.getGrades()[temp]);
  // not sensible to use parallel arrays as you might sort one array and end up pairing the wrong values
  StudentGrade[] sg = new StudentGrade[200];
  for (int i = 0; i < sg.length; i++) {
    sg[i] = new StudentGrade(t.getMatrics()[i], t.getGrades()[i]);
  }
  Arrays.sort(sg);
  for (StudentGrade s : sg) {
    System.out.println(s);
  }
}
}
