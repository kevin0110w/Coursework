public class Main {
  public static void main(String[] args) {
    Trumpet t = new Trumpet();
    Violin v = new Violin();
    DisplayVisitor dv = new DisplayVisitor();
    HVisitor hv = new HVisitor();
    t.accept(dv);
    t.accept(hv);
    v.accept(dv);
    v.accept(hv);
  }
}
