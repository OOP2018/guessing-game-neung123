package app;

import game.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

/**
 * A Controller for a window that shows the value of a current number.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class GameView implements java.util.Observer {
        /** the stage (top-level window) for showing scene */
        private Stage stage;
        /** the label that shows the counter value. */
        private Label label;

    /**
     * Initialize a CounterView, which shows value of a counter.
     */
    public GameView() {
            initComponents();
        }

    /**
     * Prepare everything for running.
     */
        private void initComponents() {
            stage = new Stage();
            HBox root = new HBox();
            root.setPadding(new Insets(10));
            root.setAlignment(Pos.CENTER);
            label = new Label("   ");
            label.setPrefWidth(300);
            label.setFont(new Font("Comic Sans MS", 120.0));
            label.setAlignment(Pos.CENTER);
            root.getChildren().add(label);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Current number");
            stage.sizeToScene();
        }

    /** Show the window and update the counter value. */
    public void run() {
        stage.show();
        displayCount();
    }

    /**
     * Display on the screen.
     */
    public void displayCount() {
            label.setText( String.format("%d", GuessingGameController.getCurrentNumber()) );
        }

    @Override
    public void update(Observable o, Object arg) {
            displayCount();
        }
    }

