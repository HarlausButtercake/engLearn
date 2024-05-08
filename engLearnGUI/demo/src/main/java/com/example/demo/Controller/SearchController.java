package com.example.demo.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import com.example.demo.Manager.Dictionary;
import com.example.demo.Manager.DictionaryCommandline;
import com.example.demo.Manager.DictionaryManagement;
import com.example.demo.Manager.Word;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class SearchController extends DictionaryCommandline {
    @FXML
    private ListView<String> wawa;

    @FXML
    private Button speak;
    @FXML
    private Button removeBut;

    @FXML
    private TextField textField;

    @FXML
    private TextField wTarget;
    @FXML
    private TextField wPronun;
    @FXML
    private TextField wDef;

    private ArrayList<Word> arrBase;
    @FXML
    public void initialize () {
        arrBase = searchKeyword("");
        ObservableList<String> show = FXCollections.observableArrayList(Dictionary.getTargetArray(Dictionary.get()));
        wawa.setItems(show);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            arrBase = searchKeyword(newValue);
            ObservableList<String> bum = FXCollections.observableArrayList(Dictionary.getTargetArray(arrBase));
            wawa.getItems().clear();
            wawa.setItems(bum);
        });

        wawa.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Check for double-click
                String selectedItem = wawa.getSelectionModel().getSelectedItem();
                // System.out.println("Selected Item: " + selectedItem);
                Word word = new Word(searchKeyword(selectedItem).get(0));
                wTarget.setText(word.getTarget());;
                wPronun.setText(word.getWord_pronounce());;
                wDef.setText(word.getExplain());
                speak.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                        Voice kevin = VoiceManager.getInstance().getVoice("kevin16");
                        if (kevin != null) {
                            kevin.allocate();
                            kevin.speak(word.getTarget());
                            kevin.deallocate();
                        } else {
                            System.err.println("The specified voice is not available.");
                        }
                    }
                });
                removeBut.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        arrBase.remove(removeFromGui(word.getTarget()));
                        ObservableList<String> bum = FXCollections.observableArrayList(Dictionary.getTargetArray(arrBase));
                        wawa.getItems().clear();
                        wawa.setItems(bum);
                    }
                });
            }
        });

        

    }
}
