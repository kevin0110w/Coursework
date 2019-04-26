public class NewFile implements Runnable{
  private int x;

  public  NewFile() {
    this.x = 0;
  }

  public int getX() {
    return x;
  }

  public void setX(int y) {
    synchronized(this) {
      x = y;
    }
  }

  public void increment() {
    synchronized(this) {
      this.x ++;
    }
  }


  public static void main(String[] args) {
    NewFile y = new NewFile();
    int n = 100;
    Thread[] threads = new Thread[n];
    for (int i = 0; i<threads.length; i++) {
      threads[i] = new Thread(y);
      threads[i].start();
    }
    try {
      for (int i = 0; i<n; i++) {
        threads[i].join();
      }
    } catch (InterruptedException e) {

    }
    System.out.println(y.getX());
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      this.increment();
    }
  }
}
