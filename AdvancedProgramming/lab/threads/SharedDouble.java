package lab.threads;

public class SharedDouble {
	private Double d;
	
	public Double getD() {
		return this.d;
	}
	
	public void setD(Double d) {
		this.d = d;
	}
	
	/**
	 * To avoid race conditions, can use synchorized in method name or wrapped around comparison
	 * @param a
	 */
	//	public synchronized compared(Double a) {
	public void compare(Double a) {
		//		 synchronized (this){
		if (a>this.d) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			this.d = a;
		}
		//		 }
	}
}
