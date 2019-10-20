public class Card {
	private final int face;
	private final int suit;
	private int dealed = 0;

	public Card(int faceInput, int suitInput) {
		this.face = faceInput;
		this.suit = suitInput;
	}

	public void DealThisCard() {
		this.dealed = 1;
	}

	public int getFace() {
		return this.face;
	}

	public int getSuit() {
		return this.suit;
	}

	public boolean getSituation() {
		return (this.dealed == 1) ? true : false;
	}
}