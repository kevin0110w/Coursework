import java.io.Console;

public class Q1 {
  private String name;
  private String size;
  public Q1(String size) {
    this.size = size;
    this.name = "";
  }

  public void print(String name) {
    this.name = name;
    System.out.println(this.size + " " + this.name);
  }


  public static void main(String[] args) {
    Q1 big = new Q1("big");
    Q1 small = new Q1("small");

    big.print("Boltzmann");
    small.print("Einstein");

    big = small;

    big.print("Maxwell");

    String name = "Feynman";

    Q1 big2 = new Q1("big");
    big = big2;
    big.print(name);

  }
}
