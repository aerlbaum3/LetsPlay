import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TicTacToeGame game =  new TicTacToeGame();
		Board board = new Board();
		
		String playGame = "Yes";
		int xWins = 0;
		int oWins = 0;
		boolean winner;
		Scanner keyboard = new Scanner(System.in);
		//as long as user wants to play start game again
		while(playGame.equalsIgnoreCase("yes")) {
			game =  new TicTacToeGame();
			//put game into a booleon for winner to know if it needs to increment
			//the players score in between games.
			winner = game.playGame();
			
			if(winner) {
				//if the winner won on gameTurn is equal to X_SPOT then the x score is plussed
				if (game.getTurn() == board.X_SPOT) {
				xWins++;
				}else if (game.getTurn() == board.O_SPOT) {
				oWins++;
					}
			}
			System.out.println("X = " + xWins);
			System.out.println("O = " + oWins);
			System.out.println("Do you want to play again? (yes/no)");
			playGame = keyboard.nextLine();
			
		}
		
		if (playGame.equalsIgnoreCase("No")){
			System.out.println("Thank you for playing!");		}
		
		
	}
}