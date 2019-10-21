public class CardBiggest {
    public static void main(String args[]) {
        CardUtils myCard = new CardUtils();
        System.out.println("---------------------");
        System.out.println("Creating a Deck of Cards...");
        myCard.CreateCardSet();
        System.out.println("---------------------");
        System.out.println("Shuffling This Deck of Cards...");
        System.out.println("---------------------");
        myCard.ShuffleCards(3);
        System.out.println("Dealing Thirteen Cards to Each Player...");
        Integer cards[][] = new Integer[4][13];
        System.out.println("---------------------");
        for(int player = 0;player < 4;player++) {
            for(int card = 0;card < 13;card++) {
                cards[player][card] = myCard.dealCard();
                System.out.println("Player" + (player+1) + " " +myCard.getCard(cards[player][card]));
            }
        }
        System.out.println("---------------------");
        myCard.getBiggest(cards);
    }
}