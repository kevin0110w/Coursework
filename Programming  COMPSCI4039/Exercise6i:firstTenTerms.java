/*
Write a program (all in a main method) that will, for any particular integer, print out the first ten terms of its times table.

*/

import java.util.Scanner;

public class Lab6Ex1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an integer");
		int a = scanner.nextInt();
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(a + " times " + i + " = " + (a*i));
		}
		
		scanner.close();
	}

}

//  or with a do loop.

import java.util.Scanner;

public class TimesTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please type a number: ");
		int number = Integer.parseInt(s.nextLine());
		int i = 1;
		do {
			int sum = number * i;
			System.out.println(number + " x " + i + " = " + sum);
			i++;
		} while (i <= 10);
		s.close();
	}

}
