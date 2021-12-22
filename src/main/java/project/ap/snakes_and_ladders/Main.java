package project.ap.snakes_and_ladders;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("welcome.fxml"));
            Group root = new Group((Node) fxmlLoader.load());
            System.out.println("Starting Audio");
            Media music = new Media(String.valueOf(Main.class.getResource("music.mp3")));
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            System.out.println("Audio Started");
            Scene scene = new Scene(root);
            Image icon = new Image(String.valueOf(Main.class.getResource("icon.png")));
            stage.getIcons().add(icon);
            stage.setTitle("SNAKES AND LADDERS");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(windowEvent -> {
                windowEvent.consume();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("EXIT GAME");
                alert.setHeaderText("Are you sure you want to exit the game? ");
                if (alert.showAndWait().get() == ButtonType.OK){
                    System.exit(0);
                }

            });

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}