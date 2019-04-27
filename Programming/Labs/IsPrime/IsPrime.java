import java.util.*;
public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please type a number: ");
		int number = Integer.parseInt(s.nextLine());
		
		printPrime(number);
	}
	
	public static boolean isPrime(int number) {
		if (number == 2) {
			return true;
		}
		
		boolean isPrime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static void printPrime(int number) {
		for (int i = 2; i <=number; i++) {
			if (isPrime(i)) {
				System.out.println(i + " is a prime number!");	
			}
		}
	}
}
