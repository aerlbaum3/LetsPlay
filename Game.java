
import java.util.ArrayList;

public class Game {
    private Player compPlayer;
    private Player humanPlayer;
    private Deck deck;

    public Game(Player humanPlayer, Player compPlayer) {
        this.compPlayer = new Player(compPlayer.getName());
        this.humanPlayer = new Player(humanPlayer.getName());
        deck = new Deck();
    }

    public void startGame() {
        deck.shuffleDeck();
        for (int i = 0; i < 5; i++) {
            compPlayer.addToHand(deck.drawCard());
            humanPlayer.addToHand(deck.drawCard());
        }
    }

    public boolean isGameOver() {
        if (deck.getCards().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void playTurn(Player player) {
        player.addToHand(deck.drawCard());
    }
    public Player getHumanPlayer() {
    	return humanPlayer;
    }
    public Player getCompPlayer() {
    	return compPlayer;
    }
    public Deck getDeck() {
    	return deck;
    }
    

    public void endGame(Player player1, Player player2, int points1, int points2) {
        System.out.println("Results:");
        System.out.println(player1 + ": " + points1);
        System.out.println(player2 + ": " + points2);
        if (points1 > points2) {
            System.out.println("Player 1 is the winner");
        } else if (points2 > points1) {
            System.out.println("Player 2 is the winner");
        } else {
            System.out.println("It's a tie");
        }
    }
}