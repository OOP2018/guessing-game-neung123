package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * game.Main Class for call and connect everything.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GuessingGame.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Guessing Game");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e){
            System.out.println("Exception creating scene: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
