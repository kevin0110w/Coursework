public class StudentGrade implements Comparable<StudentGrade> {
  private String matric;
  private String grade;

  public StudentGrade(String matric, String grade) {
      this.matric = matric;
      this.grade = grade;
  }

  public String getName() {
    return this.matric;
  }

  public String getGrade() {
    return this.grade;
  }

  public String toString() {
    return this.matric + " = " + this.grade;
  }

  @Override
  public int compareTo(StudentGrade o) {
    int i = 0;
    if (getGrade().charAt(0) < o.getGrade().charAt(0)) {
      i= 1;
    } else if (getGrade().charAt(0) == o.getGrade().charAt(0) && (int)getGrade().charAt(1) <= (int)o.getGrade().charAt(1)) {
      i= 1;
    } else {
      i= -1;
    }
    return i;
  }
}
