package lab.threads;

public class PrimeNumberObject {
	private int primeNumber;
	private int number;
	
	public PrimeNumberObject(int primeNumber, int number) {
		this.primeNumber = primeNumber;
		this.number = number;
	}
	
	public String toString() {
		return this.number + ": " + this.primeNumber;
	}
}
