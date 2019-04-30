public class CounterExample {
    public static class MyCounter {
      private int count = 0;
      public int getCount() {
        return this.count;
      }

      public void setCount(int count) {
        this.count = count;
      }
    }
    public static class Counter extends Thread {
      private MyCounter count;
      private int n;

      public Counter(MyCounter counter, int n) {
        this.count = counter;
        this.n = n;
      }

      public void run() {
        for (int i = 0; i < n ; i++) {synchronized(count) {
          int temp = count.getCount();
          temp++;
          count.setCount(temp);
        }}
      }
    }
    public static void main(String[] args) {
      MyCounter count = new MyCounter();
      int threads = 100;
      Counter[] c = new Counter[100];
      for (int i = 0; i < c.length; i++) {
        c[i] = new Counter(count, 100);
        c[i].start();
      }
      try {
        for (int i = 0; i < c.length; i++) {
          c[i].join();
        }

        } catch (Exception e) {
      }
      System.out.println(count.getCount());
    }
}
