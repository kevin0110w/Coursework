package lab.threads;

import java.util.*;
public class IsPrime {
	/**
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		System.out.println("Please type a number: ");
		int number = Integer.parseInt(s.nextLine());
		printPrime(number);
	}*/
	
	public boolean isPrime(int number) {
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
	
	public void printPrime(int number) {
		for (int i = 2; i <=number; i++) {
			if (isPrime(i)) {
				System.out.println(i + " is a prime number!");	
			}
		}
	}
}
