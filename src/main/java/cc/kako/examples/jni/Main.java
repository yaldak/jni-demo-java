package cc.kako.examples.jni;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TITLE = "JNI Lab";

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/MainScene.fxml"));
        Scene mainScene = new Scene(loader.load());

        primaryStage.setScene(mainScene);
        primaryStage.setTitle(TITLE);
        primaryStage.show();
    }
}
