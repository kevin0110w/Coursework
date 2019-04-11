public class UniversityCourse implements Comparable<UniversityCourse> {
  private int numberOfStudents;
  private String courseName;

  public UniversityCourse(int numberOfStudents, String name) {
    this.numberOfStudents = numberOfStudents;
    this.courseName = name;
  }

  public String toString() {
    return this.courseName + " (" + this.numberOfStudents + ")";
  }

  public int getNumber() {
    return this.numberOfStudents;
  }

  @Override
  public int compareTo(UniversityCourse x) {
    if (getNumber() < x.getNumber()) {
      return 1;
    } else if (getNumber() > x.getNumber()) {
      return -1;
    } else {
      return 0;
    }
  }
}
