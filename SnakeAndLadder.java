import java.util.Random;

public class SnakeAndLadder {
	// Declared Constant variable
	final int PLAYERS = 1;
	final int NO_PLAY = 1;
	final int SNAKE = 2;
	final int LADDER = 3;
	final int START_POSITION = 0;
	final int WINING_POSITION = 100;

	// Declared instance variable
	int playerPosition = 0;

	// Declare static variable
	static int countDiceRoll = 0;

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
		while (playerPosition != WINING_POSITION) {
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
				playerPosition = (playerPosition - diceNumber);
				if (playerPosition < 0) {
					playerPosition = START_POSITION;
				}
				System.out.println("You got Snake move backward to the position: " + playerPosition);

				break;
			case LADDER:
				int tempPlayerPos = (playerPosition + diceNumber);

				if (tempPlayerPos > WINING_POSITION) {
					System.out.println("you can't move");
				} else {
					playerPosition = tempPlayerPos;
					System.out.println("You got Ladder move forword to the position: " + playerPosition);
				}
				break;
			}
			System.out.println("player position:" + playerPosition);
		}
		// checking wining condition
		if (playerPosition == WINING_POSITION) {
			System.out.println("player won the game!!!!");
		}
		System.out.println("Total number of times dice rolls: " + countDiceRoll);
	}

	public static void main(String[] args) {
		SnakeAndLadder salObject = new SnakeAndLadder();
		salObject.checkPlayerPosition();
	}

}
