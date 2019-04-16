public class ExamSnippet {
  public static void IntChange(Integer x) {
    x+=3;
  }
  public static void main(String[] args) {
    Integer a = 2;
    IntChange(a);
    System.out.println(a);
  }
}
