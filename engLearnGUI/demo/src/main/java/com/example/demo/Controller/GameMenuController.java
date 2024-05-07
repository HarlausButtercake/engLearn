package com.example.demo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.example.demo.Main;
import com.example.demo.Game.GameManagement;
import com.example.demo.Game.Question;
import com.example.demo.Game.Questionnaire;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GameMenuController extends MainController {

    @FXML
    private Button casual;
    @FXML
    private Button ranked;

    @FXML
    private AnchorPane gameWindow;

    // protected ArrayList<String> selectionList;
    protected int allowRedo;

    @FXML
    public void initialize() {
        ranked.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                allowRedo = 0;
                changeWindow("GameSelect.fxml", gameWindow);
            }
        });

        casual.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("SearchGuiCompUpdt.fxml", gameWindow);
            }
        });
    }

    // @FXML
    // public void initialize() {

    // // casual.setOnAction(new EventHandler<ActionEvent>() {
    // // @Override
    // // public void handle(ActionEvent event) {

    // // // changeWindow("GameSelect.fxml", gameWindow);
    // // }
    // // });

    // ranked.setOnAction(new EventHandler<ActionEvent>() {
    // @Override
    // public void handle(ActionEvent event) {
    // // Collections.shuffle(Questionnaire.get());
    // // int i = 1;
    // // for (Question question : Questionnaire.get()) {
    // // selectionList = new ArrayList<>();
    // // selectionList.add("null");
    // // // System.out.print("Question " + i + ": ");
    // // // System.out.println(question.toString());
    // // question.handle(0, i, selectionList);

    // // changeWindow("GameSelect.fxml", gameWindow);
    // // i++;
    // // }
    // changeWindow("GameSelect.fxml", gameWindow);
    // }
    // });

    // }

}
