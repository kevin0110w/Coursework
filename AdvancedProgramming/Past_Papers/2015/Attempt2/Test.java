public class Test {
  public static void main(String[] args) {
    Trumpet t = new Trumpet();
    Violin v = new Violin();
    HireVisitor hv = new HireVisitor();
    t.accept(hv);
    v.accept(hv);

    MusicalComposite x = new MusicalComposite();
    TrumpetLeaf tt = new TrumpetLeaf();
    ViolinLeaf vv = new ViolinLeaf();
    x.addInstrument(tt);
    x.addInstrument(vv);
    x.displayInformation();
  }
}
