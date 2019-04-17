import java.util.ArrayList;

public class StudentDatabase {
  private ArrayList<Student> students;

  public StudentDatabase() {
    this.students = new ArrayList<Student>();
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public String getName(String matric) {
    String name = "";
    for (Student aStudent : this.students) {
      if (aStudent.getMatric().equals(matric)) {
        name = aStudent.getName();
      }
    }
    if (name.equals("")) {
      name = "STUDENT NOT FOUND";
    }
    return name;
  }

  public String getProgramme(String matric) {
    String programme = "";
    for (Student aStudent : this.students) {
      if (aStudent.getMatric().equals(matric)) {
        programme = aStudent.getProgramme();
      }
    }
    if (programme.equals("")) {
      programme = "STUDENT NOT FOUND";
    }
    return programme;
  }
}
