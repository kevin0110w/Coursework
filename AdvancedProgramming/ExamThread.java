public class ExamThread {
  public static class PrintThread extends Thread {
    private int mynumber;
    public PrintThread(int n) {
      mynumber = n;

    }

    public void run() {
      System.out.println("I am thread " + mynumber);
    }
  }
  public static void main(String[] args) {
    PrintThread[] threadset1 = new PrintThread[100];
    PrintThread[] threadset2 = new PrintThread[100];
    for (int i = 0; i<100; i++) {
      threadset1[i] = new PrintThread(1);
      threadset2[i] = new PrintThread(2);
    }
    for (int i = 0; i < 100; i++) {
      threadset1[i].start();
      threadset2[i].start();
    }
    System.out.println("Finished!");
  }
}
