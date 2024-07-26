import java.util.*;

public class TicTacToeGame {
	private Board board;
	//private ArrayList<String> playerQueue = new ArrayList<String>();
	private ArrayListQueue<String> playerQueue = new ArrayListQueue<String>();
	
	
	private int turn = 1;
	
	
	
	public TicTacToeGame() {
		inputPlayerNames();
		board = new Board();
	}
	public TicTacToeGame(int turn) {
		this.turn = turn;
	}
	public int getTurn() {
		return turn;
	}

	public void inputPlayerNames() {
		
		String player1 = ("X");
		String player2  = ("O");
		
		playerQueue.enqueue(player1);
		playerQueue.enqueue(player2);
	}
	
	//starts the game
	public boolean playGame() {
		System.out.println("Welcome to the game of TicTacToe");
		board.displayBoard();
		//winner and full are initilized to full
		boolean winner = false;
		boolean full = false;
		//O_SPOT = 0
		turn = board.O_SPOT;  // this is O but when loop begins X will go first. This done so that 
						// there is a winner it will stay on turn
		Scanner keyboard = new Scanner(System.in);
		String player = playerQueue.peek();
		while (!winner && !full ) {
			
			turn++;
			turn %= 2;//the %2 makes sure the only numbers it will return is either 1 or 0
			//remove the player from the Queue to start its turn
			player = playerQueue.dequeue();
			System.out.print(player + " choose where you want to go(1-9): ");
			
			int move = keyboard.nextInt();
			//check if the move the user chose is valid
			while (!board.isValidMove(move,turn)) {
				System.out.println("That is not a valid move, try again ");
				move = keyboard.nextInt();
			}
			playerQueue.enqueue(player);
			board.displayBoard();
			winner = board.checkWinner(turn);
			full = board.isFull();
			
		}
		
		
		displayWinner(player, winner);
		return winner;
		
	}

	//method to display the winner
	public String displayWinner(String player, boolean winner) {
		if(winner) {
			return player + " won.";
		}
		else {
			return "Draw";
		}
		
		
	}
}