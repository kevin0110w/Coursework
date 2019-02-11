package lecture_material.threading;

import java.util.Random;
/**
 * The purposes of this class is to make use of a thread's interrupted status
 */
public class InterruptTest {
	public static class InterruptableThread implements Runnable {
		
		/**
		 * While the thread is not in an interrupted state, keep printing numbers
		 */
		@Override
		public void run() {
			int i = 0;
			while(Thread.currentThread().isInterrupted()==false) {
				System.out.println(i++);
			}	
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new InterruptableThread());
		t.start();
		int r = new Random().nextInt();
		for (int i = 0; i < r; i++) {
			
		}
		t.interrupt();
	}
}
