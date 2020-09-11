import java.util.Random;

public class SnakeAndLadder {
	// initializing variable
	
	final int PLAYERS = 1;
	final int NO_PLAY = 1;
	final int SNAKE = 2;
	final int LADDER = 3;
	final int START_POSITION = 0;
	final int WINING_POSITION = 100;
	
	int position = 0;
	int turn = 0;
	static int countDiceRoll = 0;

	int numOfPlayer = 2;

	int playerPositionArray[] = new int[numOfPlayer];

	public void setPlayerPosition() {
		for (int i = 0; i < playerPositionArray.length; i++) {
			playerPositionArray[i] = 0;
		}

	}

	// function to get dice number between 1 to 6
	public static int getDiceNumber() {
		countDiceRoll++;
		Random random = new Random();
		return random.nextInt(6) + 1;

	}

	// function to get number between 1 to 3
	public static int typeOfMove() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	// check for player position
	public void checkPlayerPosition() {

		for (int i = 0; i < numOfPlayer; i++) {
			int diceNumber = getDiceNumber();
			int moveType = typeOfMove();
			System.out.println("--------------------------");
			System.out.println("dice number: " + diceNumber);
			System.out.println("move type: " + moveType);
			System.out.println("--------------------------");

			switch (moveType) {
			case NO_PLAY:
				System.out.println("No play: player in same position");
				break;
			case SNAKE:
				int temp1 = (playerPositionArray[i] - diceNumber);

				if (temp1 > WINING_POSITION) {
					System.out.println("you can't move");
				} else {
					playerPositionArray[i] = temp1;
					if (playerPositionArray[i] < 0) {
						playerPositionArray[i] = START_POSITION;
					}
					System.out.println("You got Snake move backward to the position: " + playerPositionArray[i]);
					

				}

				break;
			case LADDER:
				int temp = (playerPositionArray[i] + diceNumber);

				if (temp > WINING_POSITION) {
					System.out.println("you can't move");
				} else {
					playerPositionArray[i] = temp;
					System.out.println("You got Ladder move forword to the position: " + playerPositionArray[i]);
					if (playerPositionArray[i] != WINING_POSITION) {
						checkPlayerPosition();

					}
				}

				break;
			}

		}

	}

	public void turn() {
		setPlayerPosition();
		while (turn != 1) {
			for (int i = 0; i < playerPositionArray.length; i++) {
				System.out.println("player turn: " + (i + 1));
				checkPlayerPosition();

				if (playerPositionArray[i] == WINING_POSITION) {
					turn = 1;
					System.out.println("player " + (i + 1) + " win");
					break;
				}
			}
		}

		for (int i = 0; i < numOfPlayer; i++) {
			System.out.println("player" + ":" + (i + 1) + " position: " + playerPositionArray[i]);
		}

		System.out.println("Total number of times dice rolls: " + countDiceRoll);
	}

	public static void main(String[] args) {
		SnakeAndLadder object = new SnakeAndLadder();
		object.turn();

	}

}
