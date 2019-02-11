package lecture_material.threading;

/**
 * Naming threads when implement the Runnable interface
 */
public class ThreadNameTest {
	private static class PointlessThread implements Runnable {
		private int n;

		public PointlessThread(int n) {
			this.n= n;
		}
		@Override
		public void run() {
			for (int i = 0; i < n; i++) {
				System.out.println(Thread.currentThread().getName() + " Count: " + i);
			}
		}
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new PointlessThread(10), "I am thread " + i);
			threads[i].start();
		}
	}
}
