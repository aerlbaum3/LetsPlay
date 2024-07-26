import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String userName, ArrayList<Card> hand) {
        this.name = userName;
        
        this.hand = hand;
        points = 0;
    }


    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void add1Point() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;

    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                hand.remove(i);
            }
        }
    }
}