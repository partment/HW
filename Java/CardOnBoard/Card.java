public class Card {
    private int face;
    private int suit;
    private boolean dealed = false;

    public Card() {}

    public Card(int faceInput, int suitInput) {
        this.face = faceInput;
        this.suit = suitInput;
    }

    public int getFace() {
        return this.face;
    }

    public int getSuit() {
        return this.suit;
    }

    public boolean getDealed() {
        return this.dealed;
    }

    public void setDealed() {
        this.dealed = true;
    }
}