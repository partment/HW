import java.security.SecureRandom;

public class CardUtils {
    private static final SecureRandom random = new SecureRandom();
    private static final int AMOUNT_OF_CARDS = 52;

    private final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; 

    private Card[] deck = new Card[AMOUNT_OF_CARDS];

    public void CreateCardSet() {
        int[] suits = {0, 1, 2, 3};

        for(int count = 0;count < this.deck.length;count++) {
            deck[count] = new Card(count % 13, suits[count / 13]);
        }
    }

    public void ShuffleCards() {
        for (int first = 0; first < this.deck.length; first++) {
            int second = this.random.nextInt(AMOUNT_OF_CARDS);

            Card temp = this.deck[first];   
            this.deck[first] = this.deck[second];
            this.deck[second] = temp;       
        }
    }

    public int dealCard() {
        int index = this.random.nextInt(AMOUNT_OF_CARDS);
        while(this.deck[index].getSituation()) {
            index = this.random.nextInt(AMOUNT_OF_CARDS);
        }
        this.deck[index].DealThisCard();
        return index;
    }

    public int getAmount() {
        return this.deck.length;
    }

    public String getCard(int index) {
        if(this.deck[index].getSituation()) {
            return faces[this.deck[index].getFace()] + " of " + suits[this.deck[index].getSuit()];
        }else {
            return "This card hasn't been dealed yet, can't show you.";
        }
    }

    /*public String getBiggest(Integer cards[]) {
        int currentbiggest = 0;
        for(int count = 0;count < cards.length;count++) {
            if(this.deck[cards[currentbiggest]].getFace())
        }
    }*/
}