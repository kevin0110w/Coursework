public class Paper {
  private String name;
  private String matric;
  private double GPA;
  public Paper(String name, String matric) {
    this.name = name;
    this.matric = matric;
  }

  public void setGPA(double GPA) {
    this.GPA = GPA;
  }

  public String toString() {
    return this.name + "(" + this.matric +"): " + this.GPA;
  }
  public static void main(String[] args) {
  // int a = 4;
  // double b = 3.1445;
  // String s = String.format("a is %d, and b is %5.2f", a, b);
  // System.out.println(s);
  Paper p = new Paper("Kevin", "1234");
  System.out.println(p);
  }
}
