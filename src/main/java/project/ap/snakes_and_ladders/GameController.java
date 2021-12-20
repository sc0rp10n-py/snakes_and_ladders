package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private ImageView dice;
    @FXML
    private ImageView sound;

    public void setPlayers(String p1, String p2) {
        System.out.println("Setting Player 1");
        player1.setText("Player 1: " + p1);
        System.out.println("Setting Player 2");
        player2.setText("Player 2: " + p2);
    }

    public void roll() throws IOException {
        System.out.println("Rolling");
        try {
            Image d1 = new Image(String.valueOf(Main.class.getResource("d1.png")));
            Image d2 = new Image(String.valueOf(Main.class.getResource("d2.png")));
            Image d3 = new Image(String.valueOf(Main.class.getResource("d3.png")));
            Image d4 = new Image(String.valueOf(Main.class.getResource("d4.png")));
            Image d5 = new Image(String.valueOf(Main.class.getResource("d5.png")));
            Image d6 = new Image(String.valueOf(Main.class.getResource("d6.png")));
            int roll = (int) (Math.random() * 6) + 1;
            System.out.println("Rolled: " + roll);
            if (roll == 1) {
                dice.setImage(d1);
            } else if (roll == 2) {
                dice.setImage(d2);
            } else if (roll == 3) {
                dice.setImage(d3);
            } else if (roll == 4) {
                dice.setImage(d4);
            } else if (roll == 5) {
                dice.setImage(d5);
            } else if (roll == 6) {
                dice.setImage(d6);
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void back(ActionEvent e) throws IOException {
        System.out.println("Going Back");
        FXMLLoader game = new FXMLLoader(Main.class.getResource("welcome.fxml"));
        root = game.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
