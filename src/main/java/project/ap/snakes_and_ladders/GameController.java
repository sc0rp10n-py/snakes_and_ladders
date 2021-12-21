package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
//    public static HashMap<Integer, Integer> coordinates = new HashMap<>();
    static ArrayList<Pair<Integer, Integer>> coordinates = new ArrayList<>();
    static HashMap<Pair<Integer, Integer>, Integer> posMap = new HashMap<Pair<Integer, Integer>, Integer>();
    static HashMap<Integer, Integer> snakeCoords = new HashMap<>();
    static HashMap<Integer, Integer> ladderCoords = new HashMap<>();
    static boolean flag1 = false, flag2 = false;

    static int count = 1;
    static int pos1 = 1, pos2 = 1;
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
    @FXML
    private Circle p1ball;
    @FXML
    private Circle p2ball;

    public void setPlayers(String p1, String p2) {
        System.out.println("Setting Player 1");
        player1.setText("Player 1: " + p1);
        System.out.println("Setting Player 2");
        player2.setText("Player 2: " + p2);
    }

    public int roll() throws IOException {
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
                return 1;
            } else if (roll == 2) {
                dice.setImage(d2);
                return 2;
            } else if (roll == 3) {
                dice.setImage(d3);
                return 3;
            } else if (roll == 4) {
                dice.setImage(d4);
                return 4;
            } else if (roll == 5) {
                dice.setImage(d5);
                return 5;
            } else if (roll == 6) {
                dice.setImage(d6);
                return 6;
            } else {
                System.out.println("Error");
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
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

    public void play() throws IOException {
        System.out.println(posMap);
        System.out.println(posMap.values());
        int x1 = (int)p1ball.getLayoutX();
        int y1 = (int)p1ball.getLayoutY();
        int x2 = (int)p2ball.getLayoutX();
        int y2 = (int)p2ball.getLayoutY();
//        System.out.println(coordinates);

        boolean a1 = ((int) p1ball.getLayoutX()  == 68) &&  ((int) p1ball.getLayoutY() == 141);
        boolean a2 = ((int) p1ball.getLayoutX()  == 68) &&  ((int) p1ball.getLayoutY() == 141);

        if (count % 2 != 0){
            if (flag1){
                int roll = roll();
                pos1 = pos1 + roll;
                if (pos1 <= 100){
                    p1ball.setLayoutX(coordinates.get(pos1 - 1).getKey());
                    p1ball.setLayoutY(coordinates.get(pos1 - 1).getValue());
                }

                if (ladderCoords.containsKey(pos1)){
                    int pos = ladderCoords.get(pos1);
                    p1ball.setLayoutX(coordinates.get(pos-1).getKey());
                    p1ball.setLayoutY(coordinates.get(pos-1).getValue());
                    pos1 = pos;

                }
                if (snakeCoords.containsKey(pos1)){
                    int pos = snakeCoords.get(pos1);
                    p1ball.setLayoutX(coordinates.get(pos-1).getKey());
                    p1ball.setLayoutY(coordinates.get(pos-1).getValue());
                    pos1 = pos;
                }
            }
            else{
                int roll = roll();
                if (roll == 1){
                    flag1 = true;
                    p1ball.setLayoutX(coordinates.get(pos1-1).getKey());
                    p1ball.setLayoutY(coordinates.get(pos1-1).getValue());
                }
            }
        }
        else{
            if (flag2){
                int roll = roll();
                pos2 = pos2 + roll;
                if (pos2 <= 100){
                    p2ball.setLayoutX(coordinates.get(pos2 - 1).getKey());
                    p2ball.setLayoutY(coordinates.get(pos2 - 1).getValue());
                }
                if (ladderCoords.containsKey(pos2)){
                    int pos = ladderCoords.get(pos2);
                    p2ball.setLayoutX(coordinates.get(pos-1).getKey());
                    p2ball.setLayoutY(coordinates.get(pos-1).getValue());
                    pos2 = pos;
                }
                if (snakeCoords.containsKey(pos2)){
                    int pos = snakeCoords.get(pos2);
                    p2ball.setLayoutX(coordinates.get(pos-1).getKey());
                    p2ball.setLayoutY(coordinates.get(pos-1).getValue());
                    pos2 = pos;
                }
            }
            else {
                int roll = roll();
                if (roll == 1) {
                    flag2 = true;
                    p2ball.setLayoutX(coordinates.get(pos2-1).getKey());
                    p2ball.setLayoutY(coordinates.get(pos2-1).getValue());
                }
            }
        }
        count++;
    }

}
