import java.util.Random;
import java.util.*;

public class GuessingGame {

	public static void main(String[] args) {
		Random random = new Random();
		int randomNumber = random.nextInt(99);
		
		guessingGame(randomNumber);
	}
	
	public static void guessingGame(int randomNumber) {
		int i = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Input number: ");
		while (i <= 9) {
			int guess = Integer.parseInt(s.nextLine());
			
			if (guess == randomNumber) {
				System.out.println("You guessed correctly!");
				System.out.println("Player counter: " + (i+1));
				break;
			} 
			
			if (guess < randomNumber && i<9) {
				System.out.println("Too low! Guess again");
				System.out.println("Player counter: " + (i+1));
			} else if (guess < randomNumber && i == 9) {
				System.out.println("Too low!");
				System.out.println("Player counter: " + (i+1));
				System.out.println("Out of guesses! Too bad!");
			} if (guess > randomNumber && i<9)  {
				System.out.println("Too high! Guess again");
				System.out.println("Player counter: " + (i+1));
			} else if (guess > randomNumber && i == 9) {
				System.out.println("Too high!");
				System.out.println("Player counter: " + (i+1));		
				System.out.println("Out of guesses! Too bad!");
			}
			i++;
		
		}
	}

}
