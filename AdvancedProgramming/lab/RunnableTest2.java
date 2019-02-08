package lab;

public class RunnableTest2 extends Thread {
	private String name;

	public RunnableTest2(String name) {
		this.name = name;
	}
	public String getAName() {
		return this.name;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello World! My name is " + this.getAName());
	}


	public static void main(String[] args) {
		int nThreads = 10;
		Thread[] threads = new Thread[nThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new RunnableTest2("Bill" + i));
			threads[i].start();
		}
		System.out.println("HELLO");
		for (int i = 0; i<threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hello");
	}
}
