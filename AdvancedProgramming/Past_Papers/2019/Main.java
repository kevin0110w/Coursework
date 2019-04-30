public class Main {
  public static void main(String[] args) {
    ConcreteOffice c = new ConcreteOffice("Uni Avenue");
    ConcreteBurglarAlarmDecorator bad = new ConcreteBurglarAlarmDecorator(c);
    bad.openDoor();
    bad.burglar();
  }
}
