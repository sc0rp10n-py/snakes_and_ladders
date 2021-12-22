package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Group root;
//    static String p1, p2;



    @FXML
    private MediaView mediaView;
    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private Button roll;
    @FXML
    private Button back;
    @FXML
    private Button sound;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Image soundON = new Image(String.valueOf(Main.class.getResource("soundON.jpg")));
            Image soundOFF = new Image(String.valueOf(Main.class.getResource("soundOFF.png")));
            ImageView soundImage = new ImageView(soundON);
            soundImage.setFitHeight(38);
            soundImage.setFitWidth(38);
            sound.setGraphic(soundImage);
            sound.setOnAction(event -> {
                if (Main.mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
                    Main.mediaPlayer.stop();
                    soundImage.setImage(soundOFF);
                } else {
                    Main.mediaPlayer.play();
                    soundImage.setImage(soundON);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void start(ActionEvent e) throws IOException {
        try {
            String p1 = player1.getText();
            String p2 = player2.getText();
            System.out.println("Player 1: " + p1);
            System.out.println("Player 2: " + p2);
            initialiseCoords(GameController.coordinates);
            SnakeMaps(GameController.snakeCoords);
            LadderMaps(GameController.ladderCoords);
            System.out.println("Starting Game");
            FXMLLoader game = new FXMLLoader(Main.class.getResource("game.fxml"));
            root = new Group((Node) game.load());
            GameController gameController = game.getController();
            System.out.println("Game Started");
//            game.setController(gameController);
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
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void exit(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT GAME");
        alert.setHeaderText("Are you sure you want to exit the game? ");
        if (alert.showAndWait().get() == ButtonType.OK){
            System.exit(0);
        }

    }

    public void LadderMaps(HashMap<Integer, Integer> map){
        map.put(4,25);
        map.put(13,46);
        map.put(33,49);
        map.put(50,69);
        map.put(42,63);
        map.put(62,81);
        map.put(74,92);
    }

    public void SnakeMaps(HashMap<Integer, Integer> map){
        map.put(40, 3);
        map.put(43,18);
        map.put(27,5);
        map.put(54,31);
        map.put(76,58);
        map.put(66,45);
        map.put(99,41);
        map.put(89,53);
    }

    public void initialiseCoords(ArrayList<Pair<Integer, Integer>> list){
        int x = 43, y = 507;
        int ct = 1;
        int ps = 1;
        for (int j = 1; j <= 10; j++){
            if (ct % 2 != 0){
                x = 43;
                for (int i = 0; i < 10; i++){
                    list.add(new Pair<>(x + (45*i), y));
                    GameController.posMap.put(new Pair<>(x + (45*i), y), ps++);
                }
            }
            else{
                x = 448;
                for (int i = 0; i < 10; i++){
                    list.add(new Pair<>(x - (45*i), y));
                    GameController.posMap.put(new Pair<>(x - (45*i), y), ps++);

                }
                x = 43;
            }
            y = 507 - (45*j);
            ct++;
        }
    }

//    public void sound(ActionEvent e) {
//        mediaPlayer.stop();
//    }
}