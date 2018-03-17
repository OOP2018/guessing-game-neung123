package game;

/**
 * Automatically find the solution for game.PornpaveeGame.
 * @author Pornpavee Seri-umnuoy
 */
public class GameSolver {

    /**
     * Play the game.NumberGame and return the solution.
     * @param game is the game.NumberGame to solve
     * @return the secret number of the game
     */
    public int play (NumberGame game){
        boolean correct = false;
        int upper = game.getUpperBound();
        int small = 0;
        int answer;

        do{
            answer = small + (upper-small)/2;
            correct = game.guess(answer);
            if(game.getMessage().contains("too small")){
                small = answer;
            }else if(game.getMessage().contains("too large")){
                upper = answer;
            }else break;
        }while (!correct);

        return answer;
    }
}
