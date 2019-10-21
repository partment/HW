import java.security.SecureRandom;
import java.util.Arrays;
import java.util.ArrayList;

public class CardUtils {
    private static final SecureRandom random = new SecureRandom();
    private static final int AMOUNT_OF_CARDS = 52;

    private final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; 

    private Card[] deck = new Card[AMOUNT_OF_CARDS];

    public CardUtils() {}

    public void CreateCardSet() {
        int[] suits = {0, 1, 2, 3};

        for(int count = 0;count < this.deck.length;count++) {
            this.deck[count] = new Card(count % 13, suits[count / 13]);
        }
    }

    public void ShuffleCards(int entropy) {
        if(entropy < 1) {
            entropy = 1;
        }
        for (int count = 0;count < this.deck.length*entropy; count++) {
            int first = this.random.nextInt(AMOUNT_OF_CARDS);
            int second = this.random.nextInt(AMOUNT_OF_CARDS);
            while(first == second) {
                second = this.random.nextInt(AMOUNT_OF_CARDS);
            }

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

    public void getBiggest(Integer cards[][]) {
        Integer sum[] = new Integer[cards.length];
        for(int player = 0;player < cards.length;player++) {
            sum[player] = 0;
            for(int card = 0;card < cards[player].length;card++) {
                sum[player] = sum[player] + Arrays.asList(this.faces).indexOf(this.faces[this.deck[cards[player][card]].getFace()]) + 1;
            }
            System.out.println("Player" + (player+1) + " " + sum[player]);
            System.out.println("---------------------");
        }
        int currentBiggest = 0;
        int currentCompare = 1;
        ArrayList<Integer> draw = new ArrayList<Integer>();
        for(int count = 1;count < cards.length;count++) {
            if(sum[currentBiggest] < sum[currentCompare]) {
                currentBiggest = currentCompare;
                currentCompare++;
            }else if(sum[currentBiggest] == sum[currentCompare]) {
                if(!draw.contains(currentBiggest)) draw.add(currentBiggest);
                draw.add(currentCompare);
                currentCompare++;
            }else {
                currentCompare++;
            }
        }
        if(draw.size() > 0) {
            System.out.print("We have " + draw.size() + " winner. ");
            for(int count = 0;count < draw.size();count++) {
                System.out.print("Player" + (draw.get(count)+1) + " ");
            }
        }else {
            System.out.println("The winner is player" + (currentBiggest+1));
        }
    }
}