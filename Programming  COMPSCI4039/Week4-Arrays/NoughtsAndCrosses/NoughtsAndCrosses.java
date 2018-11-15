import java.util.Scanner;

public class NoughtsAndCrosses {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Let's play Noughts and Crosses!");
		char[][] board = new char[3][3];
		System.out.println("Player 1, would you like to be noughts or crosses?");
		String playOne = reader.nextLine();
		char playerOne, playerTwo;
		if (playOne.equals("noughts")) {
			 playerOne = 'o';
			 playerTwo = 'x';
		} else {
			 playerOne = 'x';
			 playerTwo = 'o';
		}
		
		int playerOneCounter = 0, playerTwoCounter = 0, i = 0;
		
		do {
			System.out.println("Player 1. Please enter the coordinates of your move.");
			while (true) {
				int rowPlayerOne = reader.nextInt();
				int columnPlayerOne = reader.nextInt();
				reader.nextLine();
		
				if (board[rowPlayerOne][columnPlayerOne] == 'o' || board[rowPlayerOne][columnPlayerOne] == 'x') {
					System.out.println("Please choose again Player 1!");
				} else if (!(board[rowPlayerOne][columnPlayerOne] == 'o' || board[rowPlayerOne][columnPlayerOne] == 'x')) {
					board[rowPlayerOne][columnPlayerOne] = playerOne;
					printBoard(board);
					playerOneCounter++;
					System.out.println("Player 1 counter: " + playerOneCounter);
					break;
					}
				
			}
			i++;
			System.out.println("Player 2. Please enter the coordinates of your move.");
			while (true) {
				
				int rowPlayerTwo = reader.nextInt();
				int columnPlayerTwo = reader.nextInt();
				reader.nextLine();
			
				if (board[rowPlayerTwo][columnPlayerTwo] == 'o' || board[rowPlayerTwo][columnPlayerTwo] == 'x') {
					System.out.println("Please choose again Player 2!");
				} else if (!(board[rowPlayerTwo][columnPlayerTwo] == 'o' || board[rowPlayerTwo][columnPlayerTwo] == 'x')) {
					board[rowPlayerTwo][columnPlayerTwo] = playerTwo;
					printBoard(board);
					playerTwoCounter++;
					System.out.println("Player 2 counter: " + playerTwoCounter);
					break;
				}
			}
			i++;
		} while (i < 8);

		System.out.println("Player 1. Please enter the coordinates of your move.");
		while (true) {
			int rowPlayerOne = reader.nextInt();
			int columnPlayerOne = reader.nextInt();
			reader.nextLine();
	
			if (board[rowPlayerOne][columnPlayerOne] == 'o' || board[rowPlayerOne][columnPlayerOne] == 'x') {
				System.out.println("Please choose again Player 1!");
			} else if (!(board[rowPlayerOne][columnPlayerOne] == 'o' || board[rowPlayerOne][columnPlayerOne] == 'x')) {
				board[rowPlayerOne][columnPlayerOne] = playerOne;
				printBoard(board);
				playerOneCounter++;
				System.out.println("Player 1 counter: " + playerOneCounter);
				break;
				}
			
		}
		System.out.println("Game Over!");
	}
		
	public static void printBoard(char[][] b) {
		for (int i = 0; i<b.length; i++) {
			for (int j = 0; j<b.length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}		
	}
}
