import java.util.Scanner;

public class BlackjackSolitaire {
	private static int ROW = 4;
	private static int COL = 5;
	private Card[][] board = new Card[ROW][COL];
	private Deck deck;
	private Scanner scanner;
	private int takenSpots = 0;

	public BlackjackSolitaire() {
		this.scanner = new Scanner(System.in);
		this.deck = new Deck();
		deck.shuffle();
	}

	private boolean isValidCell(int i, int j) {
		if (i < 0 || i >= ROW)
			return false;
		if (j < 0 || j >= COL)
			return false;
		if ((i == 2 || i == 3) && (j == 0 || j == 4)) {
			return false;
		}
		return true;
	}

	public void displayGame() {
		int spot = 1;
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; j++) {
				if (isValidCell(i, j)) {
					if (board[i][j] == null) {
						System.out.print(spot);
					} else {
						System.out.print(board[i][j]);
					}
					spot++;
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	private boolean placeCard(int targetSpot, Card card) {
		int spot = 1;
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; j++) {
				if (isValidCell(i, j)) {
					if (targetSpot == spot) {
						if (board[i][j] == null) {
							board[i][j] = card;
							return true;
						} else {
							return false;
						}
					}
					spot++;
				}
			}
		}
		return false;
	}

	private int evaluate() {
		int totalScore = 0;
		for (int i = 0; i < ROW; ++i) {
			int sum = 0;
			int countAce = 0;
			int count = 0;
			for (int j = 0; j < COL; j++) {
				if (isValidCell(i, j)) {
					count++;
					sum += board[i][j].getValue();
					if (board[i][j].getValue() == 1) {
						countAce++;
					}
					System.out.printf("%s\t", board[i][j]);
				}
			}
			int score = calculateScore(sum, countAce, count);
			totalScore += score;
			System.out.printf("score: %s\n", score);
		}
		for (int j = 0; j < COL; ++j) {
			int sum = 0;
			int countAce = 0;
			int count = 0;
			for (int i = 0; i < ROW; i++) {
				if (isValidCell(i, j)) {
					count++;
					sum += board[i][j].getValue();
					if (board[i][j].getValue() == 1) {
						countAce++;
					}
					System.out.printf("%s\t", board[i][j]);
				}
			}
			int score = calculateScore(sum, countAce, count);
			totalScore += score;
			System.out.printf("score: %s\n", score);
		}
		return totalScore;
	}

	private int calculateScore(int sum, int countAce, int count) {
		if (count == 2 && countAce == 1 && sum == 11) {
			return 10;
		} else if (count >= 3 && (countAce > 0 && sum == 11) || (countAce == 0 && sum == 21)) {
			return 7;
		} else if ((countAce > 0 && sum == 10) || (countAce == 0 && sum == 20)) {
			return 5;
		} else if ((countAce > 0 && sum == 9) || (countAce == 0 && sum == 19)) {
			return 4;
		} else if ((countAce > 0 && sum == 8) || (countAce == 0 && sum == 18)) {
			return 3;
		} else if ((countAce > 0 && sum == 7) || (countAce == 0 && sum == 17)) {
			return 2;
		} else if (sum >= 22) {
			return 0;
		} else {
			return 1;
		}
	}

	public void play() {
		while (takenSpots < 16) {
			displayGame();
			Card card = dealCard();
			boolean status = false;
			while (!status) {
				System.out.println("Deal card is " + card.toString());
				System.out.println("Where would you like to put the card?");
				int spot = scanner.nextInt();
				status = placeCard(spot, card);
				if (status) {
					takenSpots++;
				} else {
					// error checking code.
					System.out.printf("The spot %d has been taken, please retry.\n", spot);
					System.out.flush();
				}
			}
		}
		displayGame();
		System.out.print("We are going to score the hands, and then pass the");
		System.out.println("  state of the table to a scoring function:");
		int score = evaluate();
		System.out.println(score);
		System.out.println("The game is done.");
	}
}
