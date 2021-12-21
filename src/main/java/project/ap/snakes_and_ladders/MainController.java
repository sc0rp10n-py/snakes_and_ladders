package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
//        GameController.coordinates.add(new Pair<>(10, 10));
        initialiseCoords(GameController.coordinates);
        SnakeMaps(GameController.snakeCoords);
        LadderMaps(GameController.ladderCoords);
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

    public void LadderMaps(HashMap<Integer, Integer> map){
        map.put(1, 38);
        map.put(4, 14);
        map.put(8, 30);
        map.put(21, 42);
        map.put(28,76);
        map.put(50, 67);
        map.put(80,99);
        map.put(71,92);
    }

    public void SnakeMaps(HashMap<Integer, Integer> map){
        map.put(36,6);
        map.put(32,10);
        map.put(48,26);
        map.put(63,18);
        map.put(88,24);
        map.put(95,56);
        map.put(97,78);
    }

    public void initialiseCoords(ArrayList<Pair<Integer, Integer>> list){
//        list.add(new Pair<>(68, 510));
        int x = 68, y = 510;
        int ct = 1;
        int ps = 1;
        for (int j = 1; j <= 10; j++){
            if (ct % 2 != 0){
                x = 68;
                for (int i = 0; i < 10; i++){
                    list.add(new Pair<>(x + (41*i), y));
                    GameController.posMap.put(new Pair<>(x + (41*i), y), ps++);
                }
            }
            else{
                x = 437;
                for (int i = 0; i < 10; i++){
                    list.add(new Pair<>(x - (41*i), y));
                    GameController.posMap.put(new Pair<>(x - (41*i), y), ps++);

                }
                x = 68;
            }
            y = 510 - (41*j);
            ct++;
        }
    }

//    public void sound(ActionEvent e) {
//        mediaPlayer.stop();
//    }
}