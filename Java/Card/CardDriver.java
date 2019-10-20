public class CardDriver {
	public static void main(String args[]) {
		CardUtils myCard = new CardUtils();
		myCard.CreateCardSet();
		myCard.ShuffleCards();
		Integer cards[] = new Integer[4];
		System.out.println("---------------------");
		for(int count = 0;count < 4;count++) {
			cards[count] = myCard.dealCard();
			System.out.println(myCard.getCard(cards[count]));
		}
		System.out.println("---------------------");
		System.out.println(myCard.getBigTwo(cards));
	}
}