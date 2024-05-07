package com.example.demo.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.Manager.Dictionary;
import com.example.demo.Manager.DictionaryManagement;
import com.example.demo.Manager.Word;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchController implements Initializable {
    @FXML
    private ListView<String> wawa;

    @FXML
    private TextField textField;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        ObservableList<String> show = FXCollections.observableArrayList(Dictionary.getTargetArray(Dictionary.get()));
        wawa.setItems(show);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            // System.out.println(newValue);;
            ObservableList<String> bum = FXCollections.observableArrayList(Dictionary.getTargetArray(DictionaryManagement.get().searchKeyword(newValue)));
            wawa.getItems().clear();
            wawa.setItems(bum);
        });

        wawa.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Check for double-click
                String selectedItem = wawa.getSelectionModel().getSelectedItem();
                System.out.println("Selected Item: " + selectedItem);
            }
        });

    }
}
