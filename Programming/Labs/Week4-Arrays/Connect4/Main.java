
public class Main {

	public static void main(String[] args) {
		Connect4Class board = new Connect4Class();
		
		if (!(board.checkTopRow())) {
		board.dropCounter(2);
		board.dropCounter(2);
		board.dropCounter(2);
		board.dropCounter(2);
		board.dropCounter(2);
		board.dropCounter(2);		
		board.dropCounter(4);
		board.dropCounter(2);
		board.dropCounter(2);
		board.dropCounter(3);
		board.dropCounter(3);
		board.dropCounter(3);
		board.dropCounter(3);
		board.dropCounter(3);
		board.dropCounter(3);
		board.dropCounter(3);
		}
	}
}
