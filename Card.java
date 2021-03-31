
public class Card {
	// the rank of the card
	private int rank;
	// the suit of the card
	private String suit;

	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String toString() {
		if (rank == 13) {
			return String.format("K%s", suit);
		} else if (rank == 12) {
			return String.format("Q%s", suit);
		} else if (rank == 11) {
			return String.format("J%s", suit);
		} else if (rank == 1) {
			return String.format("A%s", suit);
		} else {
			return String.format("%d%s", rank, suit);
		}
	}

	public int getValue() {
		if (rank > 10) {
			return 10;
		} else {
			return rank;
		}
	}
}
