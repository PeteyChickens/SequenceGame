package boardComponents;

public class Board {
	
	private Square[][] board;
	
	public Board(String gameSelected) {
		if(gameSelected.equals("Dice")) {
			createDiceBoard();
		}
	}
	
	//changes if a board place is taken or not
	public void updateBoard(int x, int y, boolean taken) {
		board[x][y].changeTaken(taken);
	}
	
	//returns the current board
	public Square[][] getBoard() {
		return board;
	}
	
	//returns the size of the board matrix
	public int getSizeOfBoard() {
		return board.length;
	}
	
	public int numContainedInSquare(int x, int y) {
		return board[x][y].getNumContained();
	}
	
	public int playerIDInSqaure(int x, int y) {
		return board[x][y].getPlayerID();
	}
	
	public boolean isSqaureTaken(int x, int y) {
		return board[x][y].isTaken();
	}
	
	//creates the matrix of the starting board state
	public void createDiceBoard() {
		
		board = new Square[6][6];
		board[0][0] = new Square(2, false);
		board[0][5] = new Square(2, false);
		board[5][0] = new Square(2, false);
		board[5][5] = new Square(2, false);
		
		board[0][1] = new Square(3, false);
		board[1][5] = new Square(3, false);
		board[4][0] = new Square(3, false);
		board[5][4] = new Square(3, false);
		
		board[0][2] = new Square(4, false);
		board[2][5] = new Square(4, false);
		board[3][0] = new Square(4, false);
		board[5][3] = new Square(4, false);
		
		board[0][3] = new Square(5, false);
		board[2][0] = new Square(5, false);
		board[3][5] = new Square(5, false);
		board[5][2] = new Square(5, false);
		
		board[0][4] = new Square(6, false);
		board[1][0] = new Square(6, false);
		board[4][5] = new Square(6, false);
		board[5][1] = new Square(6, false);

		board[1][1] = new Square(7, false);
		board[1][4] = new Square(7, false);
		board[4][1] = new Square(7, false);
		board[4][4] = new Square(7, false);
		
		board[1][2] = new Square(8, false);
		board[2][4] = new Square(8, false);
		board[3][1] = new Square(8, false);
		board[4][3] = new Square(8, false);
		
		board[1][3] = new Square(9, false);
		board[2][1] = new Square(9, false);
		board[3][4] = new Square(9, false);
		board[4][2] = new Square(9, false);
		
		board[2][2] = new Square(12, false);
		board[2][3] = new Square(12, false);
		board[3][2] = new Square(12, false);
		board[3][3] = new Square(12, false);
	}

}
