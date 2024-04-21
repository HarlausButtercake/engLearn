package com.example.englearngui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Scanner scanner = new Scanner(System.in);
    public static Dictionary dictionary = new Dictionary();
    public static BasicQuestionManagement basicQuestionManagement = new BasicQuestionManagement();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main_menu"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

//     @Override
//   public void start(Stage stage) throws Exception {
//     FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml")); // Assuming Search.fxml is your FXML file
//     Parent root = loader.load();

//     SearchController controller = loader.getController(); // Get reference to the controller

//     Scene scene = new Scene(root);
//     stage.setScene(scene);
//     stage.setTitle("Search App");
//     stage.show();
//   }

    public static void main(String[] args) {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertWordFromFile();
        launch();
    }

}