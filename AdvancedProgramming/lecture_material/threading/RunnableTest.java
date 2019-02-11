package lecture_material.threading;

public class RunnableTest {
	public static class PointlessPrint implements Runnable {
		private String message;
		private int n;
		
		public PointlessPrint(String message, int n) {
			this.message = message;
			this.n= n;
		}
		
		@Override
		public void run() {
			for (int i = 0; i <= n; i++) {
				System.out.println(i + "/" + n + " " + message);;
			}	
		}
	}
	
	public static void main(String[] args) {
/**	USING ONE THREAD **/
//		PointlessPrint p = new PointlessPrint("Hello", 100);
//		Thread t = new Thread(p);
//		t.start();
/**   USING MULTIPLE THREADS 
 *		THREADS CAN RUN AT THE SAME TIME BUT HARD TO PREDICT WHICH LINE IS PRINTED
 *		I>E WHICH THREAD IS RUNNIGN AT ANY ONE TIME
 **/
		int nThreads = 2;
		Thread[] threads = new Thread[nThreads];
		for (int i = 0; i < nThreads; i++) {
//			PointlessPrint p = new PointlessPrint("I am thread " + i, 10);
//			threads[i] = new Thread(p);
			threads[i] = new Thread(new PointlessPrint("I am thread " + i, 10));
			threads[i].start();
		}	
	}
}
