public class StudentGrade implements Comparable<StudentGrade>{
  private String matric;
  private String grade;

  public StudentGrade(String matric, String grade) {
    this.matric = matric;
    this.grade = grade;
  }

  public String getMatric() {
    return this.matric;
  }
  public String getGrade() {
    return this.grade;
  }
  public String toString() {
    return "<" + this.getMatric() +"> = <" + this.getGrade() + ">";
  }

  public boolean betterGrade(StudentGrade other) {
    boolean better = false;
    if (this.getGrade().charAt(0) < other.getGrade().charAt(0)) {
      better = true;
    } else if (this.getGrade().charAt(0) == other.getGrade().charAt(0)) {
      if (this.getGrade().charAt(1) <= other.getGrade().charAt(1)) {
        better = true;
      } else {
        better = false;
      }
    } else {
      better = false;
    }
    return better;
  }
  @Override
  public int compareTo(StudentGrade other) {
    if (!this.betterGrade(other)) {
      return 1;
    } else {
      return -1;
    }
  }
}
