package lab.threads;

	public  class RunnableTest implements Runnable {
		private String name;
		
		public RunnableTest(String name) {
			this.name = name;
		}
		
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Hello World!");
		}


	public static void main(String[] args) {
		RunnableTest  m = new RunnableTest("Bill");
		Thread t = new Thread(m);
		t.start();
	}
	}
