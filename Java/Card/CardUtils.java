import java.security.SecureRandom;
import java.util.Arrays;

public class CardUtils {
    private static final SecureRandom random = new SecureRandom();
    private static final int AMOUNT_OF_CARDS = 52;

    private final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; 

    private Card[] deck = new Card[AMOUNT_OF_CARDS];

    public void CreateCardSet() {
        int[] suits = {0, 1, 2, 3};

        for(int count = 0;count < this.deck.length;count++) {
            this.deck[count] = new Card(count % 13, suits[count / 13]);
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
            return this.faces[this.deck[index].getFace()] + " of " + this.suits[this.deck[index].getSuit()];
        }else {
            return "This card hasn't been dealed yet, can't show you.";
        }
    }

    public String getBigTwo(Integer cards[]) {
        final String[] facesPriority = {"Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Deuce"};    
        final String[] suitsPriority = {"Diamonds", "Clubs", "Hearts", "Spades"}; 
        int currentBiggest = 0;
        int currentCompare = 1;
        for(int count = 1;count < cards.length;count++) {
            if(Arrays.asList(facesPriority).indexOf(this.faces[this.deck[cards[currentBiggest]].getFace()]) == Arrays.asList(facesPriority).indexOf(this.faces[this.deck[cards[currentCompare]].getFace()])) {
                if(Arrays.asList(suitsPriority).indexOf(this.faces[this.deck[cards[currentBiggest]].getSuit()]) < Arrays.asList(suitsPriority).indexOf(this.faces[this.deck[cards[currentCompare]].getSuit()])) {
                    currentBiggest = currentCompare;
                    currentCompare++;
                }else {
                    currentCompare++;
                }
            }else if(Arrays.asList(facesPriority).indexOf(this.faces[this.deck[cards[currentBiggest]].getFace()]) < Arrays.asList(facesPriority).indexOf(this.faces[this.deck[cards[currentCompare]].getFace()])) {
                currentBiggest = currentCompare;
                currentCompare++;
            }else {
                currentCompare++;
            }
        }
        return "The winner is Player" + (currentBiggest+1) + " (" + this.getCard(cards[currentBiggest]) + ")";
    }
}