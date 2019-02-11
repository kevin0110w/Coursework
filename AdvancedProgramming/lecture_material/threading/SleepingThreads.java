package lecture_material.threading;
import java.util.Timer;

public class SleepingThreads {
	private static class PointlessThread extends Thread {
	private Timer t = new Timer();
		public PointlessThread() {

		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("Thread " );
			} catch (InterruptedException e) {
				System.out.println("You woke me up!");
			}
		}

		public static void main(String[] args ) throws InterruptedException {
			long startTime = System.currentTimeMillis();
			PointlessThread[] m = new PointlessThread[5];
			for (int i =0 ; i<m.length;i++) {
				m[i] = new PointlessThread();
				m[i].start();
				m[i].join();
			}
//			for (int i =0 ; i < m.length; i++) {
//					m[i].join();
//			}
			long endTime = System.currentTimeMillis();
			System.out.println("Time to execute: " + (endTime - startTime));
		}
	}
}
