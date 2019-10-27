public class Card {
    //Defined faces and suits with enum.
    public enum Faces {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;}
    public enum Suits {Hearts, Diamonds, Clubs, Spades;}

    //Defined what states a card has.
    private Faces face;
    private Suits suit;
    private boolean dealed = false;

    //Two arguments constructor.
    public Card(int faceInput, int suitInput) {
        this.face = Faces.values()[faceInput];
        this.suit = Suits.values()[suitInput];
    }

    //A method to change it's dealed situation.
    public void DealThisCard() {
        this.dealed = true;
    }

    //A enum Faces type to tell what face it is.
    public Faces getFace() {
        return this.face;
    }

    //A enum Suits type to tell what suit it is.
    public Suits getSuit() {
        return this.suit;
    }

    //A boolean type to tell what a dealed situation it is.
    public boolean getSituation() {
        return this.dealed;
    }
}