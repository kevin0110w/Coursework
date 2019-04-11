public class Leaf implements Component {
    private int number;

    public Leaf(int number) {
      this.number = number;
    }
    @Override
    public int getNumber() {
      return this.number;
    }
}
