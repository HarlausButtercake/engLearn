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

public class MainController implements Initializable {
    @FXML
    private Button searchButton;
    @FXML
    private Button transButton;

    @FXML
    private AnchorPane windowComp;

    @FXML
    private void changeWindow(String fxmlPath) {
        try {
            fxmlPath = "/com/example/demo/" + fxmlPath;
            AnchorPane dum = FXMLLoader.load(getClass().getResource(fxmlPath));
            windowComp.getChildren().clear();
            windowComp.getChildren().add(dum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("SearchGuiCompUpdt.fxml");
            }
        });

        transButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeWindow("TranslateGuiComp.fxml");
            }
        });
    }

}
