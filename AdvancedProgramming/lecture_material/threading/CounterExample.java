package lecture_material.threading;

public class CounterExample {
	public static class MyCounter {
		private int count = 0;
		private int getCount() {
			return this.count;
		}
		
		public void setCount(int count) {
			this.count = count;
		}
	}
	public static class Counter extends Thread {
		private MyCounter count;
		private int n;
		
		public Counter(MyCounter count, int n) {
			this.count = count;
			this.n= n;
		}
		public void run() {
			for (int i = 0; i < n ; i++) {
				int temp = count.getCount();
				temp++;
				count.setCount(temp);
			}
		}
	}
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MyCounter count = new MyCounter();
//		Counter c = new Counter(count, 100);
//		c.start();
//		try {
//			c.join();
//		} catch (InterruptedException e) {
//			
//		}
//		System.out.println(count.getCount());
		MyCounter count = new MyCounter();
		int nCounters = 100;
		Counter[] c = new Counter[nCounters];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Counter(count, 1000);
			c[i].start();
		}
		try {
			for (int i = 0 ; i < c.length ; i++) {
				c[i].join();
			}
		} catch (InterruptedException e) {
			
		}
		System.out.println(count.getCount());
	}
}
