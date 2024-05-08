package com.example.demo.Controller;

import com.example.demo.Manager.DictionaryCommandline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddController {

    @FXML
    private TextField userTarget;
    @FXML
    private TextField userExplain;
    @FXML
    private Button confirm;
    
    @FXML
    public void initialize() {
        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!userTarget.getText().toString().equals("") && !userExplain.getText().toString().equals("")) {
                    DictionaryCommandline.get().insertFromCommandline(userTarget.getText().toString(), userExplain.getText().toString());
                }
            }
        });
    }

}
