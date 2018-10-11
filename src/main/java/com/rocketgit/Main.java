package com.rocketgit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        ResourceBundle rb = ResourceBundle.getBundle(
            "i18n.main",
            new Locale.Builder().setLanguage("en").build()
        );
        loader.setResources(rb);
        loader.setCharset(Charset.forName("UTF-8"));

        try {
            Font.loadFont(getClass().getClassLoader().getResource("Comfortaa-Regular.ttf").toExternalForm(), 13);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        Parent root = loader.load(getClass().getClassLoader().getResource("main.fxml").openStream());
        root.setStyle("-fx-font-family: 'Comfortaa';");
        stage.setTitle(rb.getString("title"));
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
