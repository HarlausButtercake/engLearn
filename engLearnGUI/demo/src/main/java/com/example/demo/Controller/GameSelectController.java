package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Collections;

// import javax.swing.plaf.multi.MultiButtonUI;

import com.example.demo.Game.MultipleOptions;
import com.example.demo.Game.Question;
import com.example.demo.Game.Questionnaire;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameSelectController extends GameMenuController {

    @FXML
    private TextField question;
    @FXML
    private Button butA;
    @FXML
    private Button butB;
    @FXML
    private Button butC;
    @FXML
    private Button butD;

    @FXML
    private Label labA;
    @FXML
    private Label labB;
    @FXML
    private Label labC;
    @FXML
    private Label labD;

    @FXML
    public void initialize () {
        Collections.shuffle(Questionnaire.get());
        for (Question question : Questionnaire.get()) {
            loadQuestion((MultipleOptions) question);

        }
    }

    public void loadQuestion(MultipleOptions ques) {
        ArrayList<String> selectionList = ques.getSelection();
        labA.setText(selectionList.get(0));
        labB.setText(selectionList.get(1));
        labC.setText(selectionList.get(2));
        labD.setText(selectionList.get(3));
    }
    
}
