public class Course implements Comparable<Course> {
  private String name;
  private int no;

  public Course(String n, int y) {
    this.name = n;
    this.no = y;
  }

  public String toString() {
    return this.name + ": (" + this.no + " students)";
  }

  public int getNo() {
    return this.no;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int compareTo(Course other) {
    if (this.getNo() >= other.getNo()) {
      return -1;
    } else {
      return 1;
    }
  }
}
