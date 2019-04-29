public class AnObserver extends Observer {
  public AnObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  public void notifyMe() {
    int number = this.subject.getData();
    System.out.println(number);
  }
}
