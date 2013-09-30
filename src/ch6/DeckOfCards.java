public class DeckOfCards {
	public static void main(String[] args) {
		// Intialize & create the deck
		int[] deck = new int[52];
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10",
			"Jack","Queen","King"};

		// Initailize the cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}

		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}

		// Display the first 4 cards
		System.out.println("Your 4 cards are: ");
		for (int i = 0; i < 4; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			System.out.println("Card #" + deck[i] + ": " + rank + " of " + suit);
		}
	}
}