
public class Connect4Class {
	private char[][] board = new char[6][7];
	
	public Connect4Class() {
		this.board = new char[6][7];
		for (int i = 0; i<this.board.length; i++) {
			for (int j = 0; j<this.board[0].length; j++) {
				this.board[i][j] = '*';
			}
		}
	}
	
	public void dropCounter(int column) {
		char counter = 'o';
		if (this.board[0][column] == counter) {
			System.out.println("Choose another column");
			System.out.println();
		}
		
		for (int i = this.board.length-1; i>=0; i--) {
			if (!(this.board[i][column] == counter)) {
				this.board[i][column] = counter;
				this.printBoard();
				break;
			}
		}
	}
	
	public void printBoard() {
		for (int i = 0; i<this.board.length; i++) {
			for (int j = 0; j<this.board[0].length; j++) {
				System.out.print(this.board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean checkTopRow() {
		char counter = 'o';
		boolean checkTopRow = false;
		for (int i = 0; i<this.board[0].length; i++) {
			if (this.board[0][i] == 'o') {
				checkTopRow = true;
			}
		}
		return checkTopRow;
	}
}
