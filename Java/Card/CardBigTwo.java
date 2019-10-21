public class CardBigTwo {
    public static void main(String args[]) {
        CardUtils myCard = new CardUtils();
        System.out.println("---------------------");
        System.out.println("Creating a Deck of Cards...");
        myCard.CreateCardSet();
        System.out.println("---------------------");
        System.out.println("Shuffling This Deck of Cards...");
        System.out.println("---------------------");
        myCard.ShuffleCards(3);
        System.out.println("Dealing One Card to Each Player...");
        Integer cards[] = new Integer[4];
        System.out.println("---------------------");
        for(int count = 0;count < 4;count++) {
            cards[count] = myCard.dealCard();
            System.out.println("Player" + (count+1) + " " +myCard.getCard(cards[count]));
        }
        System.out.println("---------------------");
        System.out.println(myCard.getBigTwo(cards));
    }
}