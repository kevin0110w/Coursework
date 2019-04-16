public class MyObject {
  public String name;
  public int age;

  public MyObject(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public static void main(String[] args) {
    final MyObject a = new MyObject("Kevin", 20);
    a.name = "billy";
    a.age = 10;
    System.out.println(a.name);
  }
}
