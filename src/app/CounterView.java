package app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

/**
 * A Controller for a window that shows the value of a Counter.
 * This has only one component (but you can add more components),
 * so write it in code instead of FXML.
 *
 */
public class CounterView implements java.util.Observer {
    /** the stage (top-level window) for showing scene */
    private Stage stage;
    /** a counter to show value of */
    private Counter counter;
    /** the label that shows the counter value. */
    private Label label;

    /**
     * Initialize a CounterView, which shows value of a counter.
     * @param counter the Counter to show.
     */
    public CounterView(Counter counter) {
        this.counter = counter;
        initComponents();
    }

    private void initComponents() {
        stage = new Stage();
        // components and containers for our window
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        // The label that will show the counter value.
        label = new Label("   ");
        // make the label big enough
        label.setPrefWidth(600);
        label.setFont(new Font("Comic Sans MS", 40.0));
        label.setAlignment(Pos.CENTER);
        // Add the label to the HBox.  You can all more components, too.
        root.getChildren().add(label);
        // Create a Scene using HBox as the root element
        Scene scene = new Scene(root);
        // show the scene on the stage
        stage.setScene(scene);
        stage.setTitle("Count");
        stage.sizeToScene();
    }

    /** Show the window and update the counter value. */
    public void run() {
        stage.show();
        displayCount();
    }

    public void displayCount() {
        label.setText( String.format("You guessed it: %2d times", counter.getCount()) );
    }

    @Override
    public void update(Observable o, Object arg) {
        displayCount();
    }
}

