/*
* File: App.java
* Author: El Miri Martin
* Copyright: 2026, El Miri Martin
* Group: Szoft I/N
* Date: 2026-04-21
* Github: https://github.com/Martin91625/
* Licenc: MIT
*/

package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainScene"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            trySetRoot(fxml);
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\nHiba az fxml fájl betöltése közben.");
        }
    }

    private static void trySetRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}