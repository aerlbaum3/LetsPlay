import java.util.ArrayList;
import java.util.*;


public class Deck {

	private ArrayList<Card> cards = new ArrayList <Card>();
	private ArrayList<String> suits = new ArrayList <String>();
	
	//constructor
	
	public Deck() {
		suits.add("Hearts");
		suits.add("Diamond");
		suits.add("Spades");
		suits.add("Clubs");
		
		for (int j = 1; j < 14; j++){
			
			for (int i = 0; i < 4; i ++) {
				Card card = new Card(String.valueOf(j), suits.get(i));
				cards.add(card);
			}
		}
	}
	public void setDeck(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public Card drawCard() {
		Card draw = (cards.get(0));
		
		cards.remove(0);
		return draw;
	}
		
	public void shuffleDeck() {
		
		Collections.shuffle(cards);
	}
		
		
		
}