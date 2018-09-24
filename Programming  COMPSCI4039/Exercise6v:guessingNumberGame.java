import java.util.Scanner;
import java.util.Random;
		
public class GuessingGame {
		/*
		Write a number guessing game. Your program should choose a random number between 0 and 99 (see below). The user should then be given 10 guesses to guess the number, with your program telling them, on each guess, whether they were too high, too low, or correct. To generate a random int between 0 and 99 use the following code:
		        Random rand = new Random();
		        int randomNum = rand.nextInt(100);
		    And add the following line to the very top of your program (above the public class line):
		        import java.util.Random;
		*/
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				int randomNum = rand.nextInt(100);
				Scanner s = new Scanner(System.in);
				
				int x = 1;
				
				System.out.println("Please provide a number between 0 and 99: " + "Guessing counter: " + x);
				int guessedNum = Integer.parseInt(s.nextLine());

				
				while (x <= 9) {
					if (guessedNum < randomNum) {
						System.out.println("Too Low");
					} else if (guessedNum > randomNum)  {
						System.out.println("Too High");
					} else if (randomNum == guessedNum) {
						System.out.println("You guessed correctly!");
						break;
					} 
					x++;
					System.out.println("Please provide another number between 0 and 99: " + "Guessing counter: " + x);
					guessedNum = Integer.parseInt(s.nextLine());
					
				}
				
				if (randomNum != guessedNum) {
					System.out.println("You are out of guesses. Bad luck!");
				}
				
				s.close();
			}

}

