public class Card {
    //Defined what state's a card has.
    private final int face;
    private final int suit;
    private boolean dealed = false;

    //Two arguments constructor.
    public Card(int faceInput, int suitInput) {
        this.face = faceInput;
        this.suit = suitInput;
    }

    //A method to change it's dealed situation.
    public void DealThisCard() {
        this.dealed = true;
    }

    //A int type to tell what face it is.
    public int getFace() {
        return this.face;
    }

    //A int type to tell what suit it is.
    public int getSuit() {
        return this.suit;
    }

    //A boolean type to tell what a dealed situation it is.
    public boolean getSituation() {
        return this.dealed;
    }
}