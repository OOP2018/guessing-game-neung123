public class GameSolver {

    /**
     * Play the NumberGame and return the solution.
     * @param game is the NumberGame to solve
     * @return the secret number of the game
     */
    public int play (NumberGame game){
        boolean correct = false;
        int answer = 0;

        while (!correct){
            answer++;
            correct = game.guess(answer);
        }

        return answer;
    }
}
