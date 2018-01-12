import java.util.Scanner;

/**
 * GameConsole is the main class for
 * interacting with a user.
 * @author Pornpavee Seri-umnuoy
 */

public class GameConsole {

	/**
	 *  Play guessing game on the console
	 *  by using an input from user.
	 *  @param game is the NumberGame for user to play.
	 *  @return the correct answer
	 */
	public int play(NumberGame game) {
		boolean correct;
		int guess;

		Scanner console = new Scanner(System.in);

		System.out.println( game.toString() );

		do {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			System.out.println( game.getMessage() );
		} while (!correct);

		return guess;
	}
	
}
