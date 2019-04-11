public class EggTimer implements Runnable {
  private int duration = 5000;
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // do nothing
    }
  }

  public static void main(String[] args) {
    new Thread(new EggTimer()).start();
  }
}
