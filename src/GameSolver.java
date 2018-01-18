/**
 * Automatically find the solution for PornpaveeGame.
 * @author Pornpavee Seri-umnuoy
 */
public class GameSolver {

    /**
     * Play the NumberGame and return the solution.
     * @param game is the NumberGame to solve
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
            }
            System.out.println(answer);
        }while (!correct);

        return answer;
    }
}
