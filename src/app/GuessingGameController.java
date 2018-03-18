package app;

import game.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Observable;

/**
 *  UI controller for events and initializing components.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class GuessingGameController extends Observable {
    private static int currentNumber = 0;
    private NumberGame game;
    private int upperBound = 100;
    private Counter counter = new Counter();
    private CounterView counterView;
    private GameView gameView;

    @FXML
    TextField textField;
    @FXML
    Label labelText;
    @FXML
    Button button1;
    @FXML
    Button button2;

    /**
     * Prepare everything for running.
     */
    public void initialize(){
        game = new PornpaveeGame(upperBound);

        counterView = new CounterView(counter);
        counter.addObserver(counterView);
        counterView.run();

        gameView = new GameView();
        this.addObserver(gameView);
        gameView.run();
    }

    /**
     * Playing number game and call another method for show the answer.
     */
    public void handlePlay(ActionEvent event) {

        String text = textField.getText().trim();
        int number = 0;
        try {
            number = Integer.parseInt(text);
        }catch (NumberFormatException e){
            labelText.setText("Please type a number");
            textField.clear();
            return;
        }
        setCurrentNumber(number);
        counter.add(1);
        boolean correct = game.guess(number);
        labelText.setText(game.getMessage());
        textField.clear();

        if(correct) newGame();
    }

    /**
     * Show the correct answer.
     */
    public void handleGiveUp(){
        labelText.setText("the secret number is " + game.getSecretNumber());
    }

    /**
     * Prepare everything for initialize a new NumberGame.
     */
    public void newGame() {
        int reply = JOptionPane.showConfirmDialog(null,
                "Right! You guessed the secret number in "+ game.getCount() + " times\nPlay again?",
                "Play A Guessing Game",
                JOptionPane.YES_NO_OPTION);
        if (reply != JOptionPane.YES_OPTION) Platform.exit();

        game = new PornpaveeGame(upperBound);
        counter.setCount(0);
    }

    /**
     * @return currentNumber
     */
    public static int getCurrentNumber() {
        return currentNumber;
    }

    /**
     * Set currentNumber and update to observer(GameView).
     * @param newNumber
     */
    public void setCurrentNumber(int newNumber){
        currentNumber = newNumber;

        setChanged();
        notifyObservers();
    }
}
