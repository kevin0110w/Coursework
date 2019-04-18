/**
Using the visitor pattern to code similar functionality into
"completely" unrelated classed
**/
public class Main {
  public static void main(String[] args) {
    Violin violin = new Violin(100, "Yamaha");
    Trumpet trumpet = new Trumpet(50);
    HireVisitor hv = new HireVisitor();
    violin.accept(hv);
    trumpet.accept(hv);
  }
}
