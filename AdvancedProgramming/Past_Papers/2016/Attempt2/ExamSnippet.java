public class ExamSnippet {
  public static int intChange(int x) {
    return x +=3;
  }

  public static void main(String[] args) {
    int a = 3;
    System.out.println(intChange(a));
  }
}
