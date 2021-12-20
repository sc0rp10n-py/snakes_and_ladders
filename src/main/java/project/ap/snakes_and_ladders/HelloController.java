package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void start(ActionEvent e) throws IOException {
        FXMLLoader game = new FXMLLoader(Main.class.getResource("game.fxml"));
        root = game.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void roll(ActionEvent e) throws IOException {
        System.out.println("Rolling");
    }

    public void back(ActionEvent e) throws IOException {
        FXMLLoader game = new FXMLLoader(Main.class.getResource("welcome.fxml"));
        root = game.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}