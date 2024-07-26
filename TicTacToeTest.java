import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	public void testGetTurn() {
        TicTacToeGame game = new TicTacToeGame();
        assertEquals(1, game.getTurn());
    }
	@Test
	public void testCheckWinnerWhenPassInAnX() {
        TicTacToeGame game = new TicTacToeGame();
        assertEquals("X won.", game.displayWinner("X", true));
    }
	
	@Test
	public void testCheckWinnerWhenPassInAnO() {
		TicTacToeGame game = new TicTacToeGame();
        assertEquals("O won.", game.displayWinner("O", true));
    }
	public void testCheckWinnerWhenPassInAnAFalseForTheWinner() {
		TicTacToeGame game = new TicTacToeGame();
        assertEquals("Draw", game.displayWinner("O", false));
    }
	
	@Test
	public void testForValidMove() {
		Board board = new Board();
		assertFalse(board.isValidMove(10, board.X_SPOT) );
		
	}
	
	
}


