
public class Board {

	int[][] board = new int[3][3];
	final private String X = "X";
	final private String O = "O";
	final protected int EMPTY = 2;   // 2 or above will mean cell is empty
	final protected int X_SPOT = 0;   // 0 will mean X
	final protected int O_SPOT = 1;
	

	//Constructor creates the board
	public Board() {
		int blank = 2;
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = blank;
				blank++;
			}
		}
		
	}
	//method to display the board nicely with numbers to the user
	public void displayBoard() {
		for(int row = 0; row < board.length; row ++) {
			System.out.println("  ");
			for(int col = 0; col < board[row].length; col++) {
				if (board[row][col] >= EMPTY) {
					System.out.print(board[row][col] - 1 + "\t");	
				} else if (board[row][col] == X_SPOT) {
					System.out.print(X + "\t");
				} else if (board[row][col] == O_SPOT) {
					System.out.print(O + "\t");
				}
			}
			System.out.println("");
		}
	}
	//checks if move is valid
	public boolean isValidMove(int move, int turn) {
		int row, col;
		//converting the number that the user entered into a row and col to find the right place for it
		if(move <= 3 && move >= 1) {
			row = 0;
			col = move - 1;
		}else if (move >= 4 && move <= 6 ) {
			row = 1;
			col = move - 4;
		}else if (move >= 7 && move <= 9 ) {
			row = 2;
			col = move - 7;
		} else {
			return false;
		} //All empty spaces have a value of 2 or more so return true that its a valid move
		if (board[row][col] >= EMPTY) {			
			board[row][col] = turn;
			return true;
		} else {//if the space has a value stored as either 0 or 1 means the space is filled
			return false;
		}
		
	}//this method checks for a winner, turn(a number stored as 0 or 1) is passed into the method
	//if there is a winner will return true on that turn making that turn(X or O) the winner
	public boolean checkWinner(int turn) {
		int row = 0;
		boolean winner = false;
		while (! winner && row < 3) {
			if(turn == (board[row][0]) && turn == board[row][1] && turn == board[row][2]) {
				
				return true;
			}
			if(turn == board[0][row] && turn == board[1][row] && turn == board[2][row]) {
				
				return true;
			}
			row++;
		}
		if(turn == board[0][0] && turn == board[1][1] && turn == board[2][2]) {
			
			return true;
		}
		if(turn == board[0][2] && turn == board[1][1] && turn == board[2][0]) {
			
			return true;
		}
		return false;		
	}
	
	//loops through the board and if all the spots are empty will return false if all the spots are full will return true
	public boolean isFull() {
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] >= EMPTY) {
					return false;
				}
		}
	}
		return true;
	}
}
