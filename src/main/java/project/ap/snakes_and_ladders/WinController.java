package project.ap.snakes_and_ladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WinController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label winner;

    public void setWinner(String name) {
        System.out.println("Winner is: " + name);
        winner.setText(name);
    }

    public void home(ActionEvent event) throws IOException {
        System.out.println("Going Home");
        FXMLLoader game = new FXMLLoader(Main.class.getResource("welcome.fxml"));
        root = game.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void restart(ActionEvent event) throws IOException {
        System.out.println("Restarting");
        FXMLLoader game = new FXMLLoader(Main.class.getResource("game.fxml"));
        root = game.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent e) {
        System.out.println("Exiting");
        System.exit(0);
    }
}
