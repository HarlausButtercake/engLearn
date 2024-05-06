package com.example.demo.Controller;

import com.example.demo.Manager.Dictionary;
import com.example.demo.Manager.DictionaryManagement;
import com.example.demo.Manager.Word;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MenuController {
    @FXML
    private ListView<String> wawa;

    @FXML
    private TextField textField;

    @FXML
    void initialize() {
        ObservableList<String> show = FXCollections.observableArrayList(Dictionary.getTargetArray(Dictionary.get()));
        wawa.setItems(show);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);;
            ObservableList<String> bum = FXCollections.observableArrayList(Dictionary.getTargetArray(DictionaryManagement.get().searchKeyword(newValue)));
            wawa.getItems().clear();
            wawa.setItems(bum);
        });
    }
}
