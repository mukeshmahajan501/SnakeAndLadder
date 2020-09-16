import java.util.Random;

public class SnakeAndLadder {
	// declared constant variable
	final int NO_PLAY = 1;
	final int SNAKE = 2;
	final int LADDER = 3;
	final int START_POSITION = 0;

	// initializing variable
	int playerPosition = 0;

	// function to get dice number between 1 to 6
	public static int getDiceNumber() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	// function to get number between 1 to 3
	public static int typeOfMove() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	int diceNumber = getDiceNumber();
	int moveType = typeOfMove();

	// function to get NO_PLAY,SNAKE AND LADDER
	public void playing() {
		switch (moveType) {
		case NO_PLAY:
			System.out.println("No play: player in same position");
			break;
		case SNAKE:
			System.out.println("player got snake");
			playerPosition = (playerPosition - diceNumber);
			break;
		case LADDER:
			System.out.println("player got ladder");
			playerPosition = (playerPosition + diceNumber);
			break;
		}
	}

	public static void main(String[] args) {
		SnakeAndLadder salObject = new SnakeAndLadder();
		salObject.playing();
	}
}
