public class ConcreteBurglarAlarmDecorator extends Decorator {
  public ConcreteBurglarAlarmDecorator(AbstractOffice office) {
    super(office);
  }

  public void openDoor() {
    System.out.println("Door is opened!");
  }

  public void burglar() {
    System.out.println("Alarm is off!");
  }
}
