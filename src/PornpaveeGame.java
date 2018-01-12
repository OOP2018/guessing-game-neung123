import java.util.Random;
/**
 * Example guessing game.
 * This class will random a number between
 * 1 and the upperBound in the Main class
 * @author Pornpavee Seri-umnuoy
 */
public class PornpaveeGame extends NumberGame {
    private int upperBound;
    private int secretNumber;
    private int countGuesses;

    /** Initialize a new default game. */
    public PornpaveeGame () {
        this(100);
    }

    public PornpaveeGame (int upperBound){
        this.upperBound = upperBound;
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        this.countGuesses = 0;
        this.secretNumber = rand.nextInt(upperBound) + 1;
        super.setMessage("I'm thinking of a number between 1 and " + upperBound);
    }

    @Override
    public boolean guess(int answer) {
        countGuesses ++;

        if(answer == secretNumber){
            setMessage("right! the secret number is " + secretNumber);
            return true;
        }else if(answer < secretNumber) setMessage(answer + " is too small");
        else if (answer > secretNumber) setMessage(answer + " is too large");
        return false;
    }

    /** Get the game upper bound. */
    public int getUpperBound() {
        return upperBound;
    }
    /** Describe the game. */
    @Override
    public String toString() {
        return "Guess a secret number between 1 and " + upperBound;
    }
    /** Get the game number of the time that you guessed in this game. */
    public int getCountGuesses() {
        return countGuesses;
    }
}
