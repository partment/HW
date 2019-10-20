public class Card {
    private final int face;
    private final int suit;
    private boolean dealed = false;

    public Card(int faceInput, int suitInput) {
        this.face = faceInput;
        this.suit = suitInput;
    }

    public void DealThisCard() {
        this.dealed = true;
    }

    public int getFace() {
        return this.face;
    }

    public int getSuit() {
        return this.suit;
    }

    public boolean getSituation() {
        return this.dealed;
    }
}