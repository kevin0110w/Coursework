import java.util.ArrayList;

public class StudentDatabase {
  private ArrayList<Student> students;

  public StudentDatabase() {
    this.students = new ArrayList<Student>();
    this.addStudents();
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public String getName(String matric) {
    String name = "";
    for (Student s : this.students) {
      if (s.getMatric().equals(matric)) {
        name = s.getName();
      }
    }
    return name;
  }

  public void print() {
    for (Student s: this.students) {
      System.out.println(s);
    }
  }

  public String getProgramme(String matric) {
  String programme = "";
  for (Student s : this.students) {
    if (s.getMatric().equals(matric)) {
      programme = s.getProgramme();
    }
  }
  return programme;
  }

  public void addStudents() {
    this.addStudent(new Student("Kevin", "0808148", "SD"));
    this.addStudent(new Student("Bill", "1", "IT"));
    this.addStudent(new Student("Ted", "23", "CS"));
    this.addStudent(new Student("Chris", "4", "DS"));
  }

  class Student {
    private String name;
    private String programme;
    private String matric;

    public Student(String name, String matric, String programme) {
      this.name = name;
      this.matric = matric;
      this.programme = programme;
    }

    public String getMatric() {
      return this.matric;
    }
    public String getName() {
      return this.name;
    }
    public String getProgramme() {
      return this.programme;
    }
    public String toString() {
      return this.name + " (" + this.matric + "): " + this.programme;
    }
  }
}
