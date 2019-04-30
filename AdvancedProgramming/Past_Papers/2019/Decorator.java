public abstract class Decorator extends AbstractOffice {
  protected AbstractOffice office;
  public Decorator(AbstractOffice office) {
    this.office = office;
  }

  public void openDoor() {
    super.openDoor();
  }
}
