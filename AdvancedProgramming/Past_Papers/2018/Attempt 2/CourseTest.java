import java.util.Arrays;

public class CourseTest {
  public static void main(String[] args) {
    Course[] catalog = new Course[4];
    for (int i = 0; i < catalog.length; i++) {
      catalog[i] = new Course("SD", (i*200));
    }

    System.out.println("Unsorted catalog");
    for (Course c : catalog) {
      System.out.println(c);
    }

    Arrays.sort(catalog);
    System.out.println("Sorted catalog");
    for (Course c : catalog) {
      System.out.println(c);
    }
  }
}
