package com.example.demo.Controller;

import com.example.demo.TranslateURL;
import com.example.demo.Manager.Dictionary;
import com.example.demo.Manager.DictionaryManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Translate;

public class TransController extends TranslateURL {
    

    @FXML
    private TextField topFil;
    @FXML
    private Label botFil;
    @FXML
    private Label topLab;
    @FXML
    private Label botLab;
    @FXML
    private Button swap;

    private int mode = 0; //en - vi

    @FXML
    void initialize() {
        swap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (mode == 0) {
                    mode = 1;
                    topLab.setText("Vietnamese");
                    botLab.setText("English");
                } else {
                    mode = 0;
                    topLab.setText("English");
                    botLab.setText("Vietnamese");
                }
            }
        });
        topFil.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String text = topFil.getText();
                botFil.setText(Translate(text, mode));
            }
        });
    }

}
