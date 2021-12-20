package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    private Stage stage;
    private Scene scene;
    private Parent root;
//    private MediaPlayer mediaPlayer;

    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private Button roll;
    @FXML
    private Button back;

    public void start(ActionEvent e) throws IOException {
        String p1 = player1.getText();
        String p2 = player2.getText();
        System.out.println("Player 1: " + p1);
        System.out.println("Player 2: " + p2);
        System.out.println("Starting Game");
        FXMLLoader game = new FXMLLoader(Main.class.getResource("game.fxml"));
        root = game.load();
        GameController gameController = game.getController();
//        game.setController(gameController);
//        roll.setOnAction(event -> {
//                    try {
//                        gameController.roll();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//        );
//        back.setOnAction(event -> {
//                    try {
//                        gameController.back();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//        );
        gameController.setPlayers(p1, p2);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent e) {
        System.out.println("Exiting");
        System.exit(0);
    }

//    public void sound(ActionEvent e) {
//        mediaPlayer.stop();
//    }
}