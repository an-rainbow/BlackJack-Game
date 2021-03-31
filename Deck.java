import java.util.Random;

public class Deck {

	public static String[] suits = { "C", "D", "H", "S" };
	private Card[] cards = new Card[52];
	private Random random = new Random();
	int dealCardIndex;

	public Deck() {
		for (int rank = 1; rank <= 13; rank++) {
			for (int suitIndex = 0; suitIndex < 4; suitIndex++) {
				cards[(rank - 1) * 4 + suitIndex] = new Card(rank, suits[suitIndex]);
			}
		}
	}

	public int size() {
		return cards.length;
	}

	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int r = random.nextInt(cards.length - i);
			swap(cards, i, r + i);
		}
	}

	public Card dealCard() {
		return cards[dealCardIndex++];
	}

	private void swap(Card[] cards, int i, int j) {
		Card tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}

}
