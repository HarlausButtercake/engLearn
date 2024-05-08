package com.example.demo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.Manager.Dictionary;
import com.example.demo.Manager.DictionaryManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {
    @FXML
    private Button searchButton;
    @FXML
    private Button transButton;
    @FXML
    private Button gameButton;
    @FXML
    private Button modifyButton;

    @FXML
    private AnchorPane windowComp;

    protected int score;

    @FXML
    protected void changeWindow(String fxmlPath, AnchorPane soso) {
        try {
            fxmlPath = "/com/example/demo/" + fxmlPath;
            AnchorPane dum = FXMLLoader.load(getClass().getResource(fxmlPath));
            soso.getChildren().clear();
            soso.getChildren().add(dum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize () {
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("SearchGuiCompUpdt.fxml", windowComp);
            }
        });

        modifyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("AddGui.fxml", windowComp);
            }
        });

        transButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("TranslateGuiComp.fxml", windowComp);
            }
        });

        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("GameMenu.fxml", windowComp);
            }
        });
    }

}
