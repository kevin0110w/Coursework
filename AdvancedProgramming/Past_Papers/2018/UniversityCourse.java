import java.util.Arrays;

public class UniversityCourse implements Comparable<UniversityCourse> {
  private int numberOfStudents;
  private String courseName;

  public UniversityCourse(int numberOfStudents, String name) {
    this.numberOfStudents = numberOfStudents;
    this.courseName = name;
  }

  public String toString() {
    return this.courseName + " (" + this.numberOfStudents + " students)";
  }

  public int getNumber() {
    return this.numberOfStudents;
  }

  @Override
  public int compareTo(UniversityCourse x) {
    if (this.getNumber() < x.getNumber()) {
      return 1;
    } else if (this.getNumber() > x.getNumber()) {
      return -1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    UniversityCourse ads = new UniversityCourse(200, "ads");
    UniversityCourse ap = new UniversityCourse(5000, "ap");
    UniversityCourse ecs = new UniversityCourse(10, "ecs");
    UniversityCourse[] sd = new UniversityCourse[3];
    sd[0] = ads;
    sd[1] = ap;
    sd[2] = ecs;
    for (int i = 0; i < sd.length; i++) {
      System.out.println(sd[i]);
    }
    Arrays.sort(sd);
    for (int i = 0; i < sd.length; i++) {
      System.out.println(sd[i]);
    }
  }
}
