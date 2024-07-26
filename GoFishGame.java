import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class GoFishGame extends Game {

    public GoFishGame(Player humanPlayer, Player compPlayer) {
        super(humanPlayer, compPlayer);
    }

    @Override
    // Calls the method from the parent class
    public void startGame() {
    	Scanner keyboard = new Scanner(System.in);
        System.out.println();
        super.startGame();
        while (!isGameOver()) {
            playTurn(getHumanPlayer());
            System.out.print("Press ENTER to continue");
            keyboard.nextLine();
            playTurn(getCompPlayer());
            System.out.print("Press ENTER to continue");
            keyboard.nextLine();
            
        }
    }

    @Override
    // Loops through the hands of all the players, and if all the hands and the deck are empty, the game is over
    public boolean isGameOver() {
        if (getHumanPlayer().getHand().size() == 0 && getCompPlayer().getHand().size() == 0 && getDeck().getCards().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void playTurn(Player player) {
        Scanner keyboard = new Scanner(System.in);
        if (player.getName().equals(getCompPlayer().getName())) {
            System.out.println("COMPUTER TURN:");

            // Arraylist to hold the numbers of the cards so that we can check for duplicates
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < player.getHand().size(); i++) {
                nums.add(Integer.parseInt(player.getHand().get(i).getRank()));
            }
            // Number that the computer will be asking for
            int num = 0;
            // For loop to find a duplicate
            for (int i = 0; i < nums.size(); i++){
                if (nums.contains(nums.get(i))){
                    num = nums.get(i);
                    i = nums.size();
                }
            }
            
            Card card = new Card(String.valueOf(num));
                
            	Collections.shuffle(player.getHand());
               
                card.setRank(player.getHand().get(0).getRank());
          //  }
            System.out.println(player.getName() + " is asking for a " + card.getRank() + ".");
            // Number to count how many cards the user got
            int temp = 0;
            // Run loop backwards since elements may be removed
            for (int i = getCompPlayer().getHand().size() - 1; i >= 0; i--) {
                if (getHumanPlayer().getHand().get(i).getRank().equals(card.getRank())) {
                    player.addToHand(getHumanPlayer().getHand().get(i));
                    getHumanPlayer().removeFromHand(getHumanPlayer().getHand().get(i));
                    temp++;
                }
            }
            if (temp == 0) {
                System.out.println("You don't have that card, the computer needs to Go Fish!");
                card = getDeck().drawCard();
                player.addToHand(card);
            } else {
                System.out.println("You gave the computer " + temp + " cards");
            }
            calcPoints(player, card);
        } else {
            System.out.println("Your hand:");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.print(player.getHand().get(i).getRank() + ", ");
            }
            System.out.println();
            System.out.println("What number do you want to ask for? ");
            int rank = keyboard.nextInt();
            Card card = new Card(String.valueOf(rank));
            // Number to count how many cards the user got
            int num = 0;
            // Run loop backwards since elements may be removed
            for (int i = getCompPlayer().getHand().size() - 1; i >= 0; i--) {
                if (getCompPlayer().getHand().get(i).getRank().equals(card.getRank())) {
                    player.addToHand(getCompPlayer().getHand().get(i));
                    getCompPlayer().removeFromHand(getCompPlayer().getHand().get(i));
                    num++;
                }
            }
            if (num == 0) {
                System.out.println("Go Fish!");
                
                card = getDeck().drawCard();
                player.addToHand(card);
                System.out.println("You drew the " + card.toString());
               
            } else {
                System.out.println("The computer gave you " + num + " cards.");
            }
            calcPoints(player, card);
        }
    }

    private static void calcPoints(Player player, Card card) {
        // Number to hold how many times it shows up in the arraylist
        int times = 0;
        for (int i = 0; i < player.getHand().size(); i++){
            if (player.getHand().get(i).getRank().equals(card.getRank())){
                times++;
            }
        }
        if (times == 4){
            System.out.println("\n" + player.getName() + " got a set of " + card.getRank());
            for (int i = player.getHand().size() - 1; i >= 0; i--) {
                if (player.getHand().get(i).getRank().equals(card.getRank())) {
                    player.getHand().remove(i);
                }
            }
            System.out.println("New Hand: " + player.getHand());
            player.add1Point();
            System.out.println(player.getName() + " now has " + player.getPoints() + " points");
        }
    }

    public void endGame() {

    }
}