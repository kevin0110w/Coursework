import java.util.Arrays;
public class Test {
public static void main(String[] args) {
  UniversityCourse[] courses = new UniversityCourse[4];
  courses[0] = new UniversityCourse(20, "AdvancedProgramming");
  courses[1] = new UniversityCourse(34, "Programming");
  courses[2] = new UniversityCourse(10, "SystemsandNetworks");
  courses[3] = new UniversityCourse(0, "ECS");

  System.out.println("Unsorted");

  for (int i = 0; i < courses.length; i++) {
    System.out.println(courses[i]);
  }

  Arrays.sort(courses);

  System.out.println("\nSorted");
  for (int i = 0; i < courses.length; i++) {
    System.out.println(courses[i]);
  }
}
}
