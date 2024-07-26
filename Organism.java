

public class Organism {

	private int row;
	private int col;
	private int state;
	
	
	public Organism(int row, int col, int i) {
		this.row = row;
		this.col = col;
		this.state = i;
	}
	
	public int getState() {
		return state;
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	
	public void reverseState() {
		state = (state + 1) % 2; //0 (dead) becomes 1(alive) and 1 becomes 0.
	}

}
