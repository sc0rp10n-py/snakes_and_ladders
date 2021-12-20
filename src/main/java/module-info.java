module project.ap.snakes_and_ladders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires javafx.media;

    opens project.ap.snakes_and_ladders to javafx.fxml;
    exports project.ap.snakes_and_ladders;
}