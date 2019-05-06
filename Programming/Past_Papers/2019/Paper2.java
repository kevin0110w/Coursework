public class Paper2 extends Paper {
  private String price;
  public Paper2(String name, String matric, String price) {
  super(name, matric);
  this.price = price;
  }

  @Override
  public String toString() {
    return super.getName() +"(" +super.getMatric() +"): " + this.price;
  }
}
