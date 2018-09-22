/*
Paper, scissors, stone. In the game paper, scissors, stone, users both choose one of paper, scissors or stone. A set of rules then determines who wins. Write a program that allows you to play the game against the computer. You should enter your choice in the keyboard and the computer should randomly choose (earlier, I gave you the code to choose a random number between 0 and 99, you can modify it to give 0 to 2 and then use some ifs to map that to the different options). The game is repeated, and the winner is the player who is the first to win three rounds. */

import java.util.*;

public class Exercise6ix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type your name: ");
		String name = sc.nextLine();
		System.out.println("Hi " + name + ". Let's play rock-paper-scissors!");
		rockPaperScissorsGame(name);
	}
	
	public static String inputChoice() {
		Scanner st = new Scanner(System.in);
		System.out.println("Please choose a shape: ");
		String shape = st.nextLine();
		return shape;
	}
	
	public static int computerChoice(int userChoiceInt) {
		Random rand = new Random();
		int computerChoiceInt = rand.nextInt(3);
		while (computerChoiceInt == userChoiceInt) {
			computerChoiceInt = rand.nextInt(3);
		}
		System.out.println("Computer chooses " + chooseShape2(computerChoiceInt) + ".");
		return computerChoiceInt;
	}
	
	public static int chooseShape(String shape) {
		int chooseShapeInt = 0;
		if (shape.equals("scissors")) {
			chooseShapeInt = 2;
		} else if (shape.equals("rock")) {
			chooseShapeInt = 1;
		} else if (shape.equals("paper")) {
			chooseShapeInt = 0;
		}
		return chooseShapeInt;
	}
	
	public static String chooseShape2(int number) {
		String chooseShape2 = "";
		if (number == 2) {
			chooseShape2 += "scissors";
		} else if (number == 1) {
			chooseShape2 += "rock"; 
		} else if (number == 0){
			chooseShape2 += "paper";
		}
		return chooseShape2;
	}
	
	public static void rockPaperScissorsGame(String name) {
		int userCounter = 0;
		int computerCounter = 0;
		
		while (userCounter < 3 || computerCounter < 3) {
			System.out.println("Current score: " + userCounter + "-" + computerCounter);
			if (userCounter == 3 || computerCounter == 3) {
				break;}
			int userInput = chooseShape(inputChoice());
			System.out.println(name + " chooses " + chooseShape2(userInput));
			int computerInput = computerChoice(userInput);
			
			
			if (userInput == 2 && computerInput == 0) {
				System.out.println("Scissors beats paper!");
				userCounter++;
			} else if (userInput == 1 && computerInput == 2) {
				System.out.println("Rock beats scissors!");
				userCounter++;
			} else if (userInput == 0 && computerInput == 1) {
				System.out.println("Paper beats rock!");
				userCounter++;
			} else if (userInput == 0 && computerInput == 2) {
				System.out.println("Scissors beats paper!");
				computerCounter++;
			} else if (userInput == 2 && computerInput == 1) {
				System.out.println("Rock beats scissors!");
				computerCounter++;
			} else if (userInput == 1 && computerInput == 0) {
				System.out.println("Paper beats rock!");
				computerCounter++;
			}
		}
	
		if (userCounter == 3) {
			System.out.println("Congratulations " + name + ". You win!");
		} else  if (computerCounter == 3){
			System.out.println("Computer wins!");
		}
		
	}
			
}

