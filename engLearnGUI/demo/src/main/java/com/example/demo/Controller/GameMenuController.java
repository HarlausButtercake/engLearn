package com.example.demo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.example.demo.Main;
// import com.example.demo.Game.GameManagement;
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
    // protected int allowRedo;

    @FXML
    public void initialize() {
        ranked.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Questionnaire.get().setAllowRedo(0);
                changeWindow("GameSelect.fxml", gameWindow);
            }
        });

        casual.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Questionnaire.get().setAllowRedo(1);
                changeWindow("GameSelect.fxml", gameWindow);
            }
        });
    }

}
