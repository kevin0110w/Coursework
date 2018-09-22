/*
Write a number guessing game. Your program should choose a random number between 0 and 99 (see below). The user should then be given 10 guesses to guess the number, with your program telling them, on each guess, whether they were too high, too low, or correct. To generate a random int between 0 and 99 use the following code:
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
    And add the following line to the very top of your program (above the public class line):
        import java.util.Random;
*/


import java.util.Scanner;
import java.util.Random;

public class Lab6Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int randomNum = rand.nextInt(100);
		Scanner s = new Scanner(System.in);
		System.out.println("Please provide a number between 0 and 99: ");
		int guessedNum = Integer.parseInt(s.nextLine());

		int x = 0;
		while (x <= 8) {
			if (randomNum == guessedNum) {
				System.out.println("You guessed correctly!");
				break;
			} else {
				System.out.println("Please provide another number between 0 and 99: ");
				guessedNum = Integer.parseInt(s.nextLine());
				x++;
			}
		}
		
		if (randomNum != guessedNum) {
			System.out.println("You are out of guesses. Bad luck!");
		}
		
		s.close();
	}

}
