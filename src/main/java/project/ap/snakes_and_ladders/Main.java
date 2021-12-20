package project.ap.snakes_and_ladders;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public void soundDisplay() {

    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("welcome.fxml"));
            Group root = new Group((Node) fxmlLoader.load());
            Media music = new Media(String.valueOf(Main.class.getResource("music.mp3")));
            MediaPlayer mediaPlayer = new MediaPlayer(music);
            mediaPlayer.setAutoPlay(true);
//            Image soundON = new Image(String.valueOf(Main.class.getResource("soundON.jpg")));
//            Image soundOFF = new Image(String.valueOf(Main.class.getResource("soundOFF.png")));
//            ImageView soundImage = new ImageView(soundON);
//            soundImage.setFitHeight(38);
//            soundImage.setFitWidth(38);
//            Button sound = new Button();
//            sound.setPrefHeight(38);
//            sound.setPrefWidth(38);
//            sound.setLayoutX(550);
//            sound.setLayoutY(20);
//            sound.setGraphic(soundImage);
//            sound.setOnAction(event -> {
//                        if (mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
//                            mediaPlayer.stop();
//                            soundImage.setImage(soundOFF);
//                        } else {
//                            mediaPlayer.play();
//                            soundImage.setImage(soundON);
//                        }
//                    }
//            );
//            root.getChildren().add(sound);
            Scene scene = new Scene(root);
            Image icon = new Image(String.valueOf(Main.class.getResource("icon.png")));
            stage.getIcons().add(icon);
            stage.setTitle("Snakes and Ladders");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}