package com.example.englearngui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class Main_menuController {
    @FXML
    private TextField user_enter;

    // @FXML
    // private ListView<String> result_list;

    
    ObservableList<String> books = FXCollections.observableArrayList("book1", "book2", "book3");
 
    @FXML
    ListView<String> result_list = new ListView<String>(books);
        // result_list.getFocusModel().focus(1);



    @FXML
    public void initialize() {
        // Initialize allWords with your word data
        result_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // Allow single selection
    }

    public void handleSearchTextChanged(KeyEvent event) {
        String searchText = user_enter.getText();
        List<String> filteredList = new ArrayList<>();
        if (searchText != null && !searchText.isEmpty()) {
            for (Word word : App.dictionary.getArr()) {
                if (word.getTarget().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(word.getTarget());
                }
            }
        }
        // ObservableList<String> words = FXCollections.observableArrayList("apple", "banana", "...");

        // result_list.getItems().setAll(filteredList);

        // result_list.setItems(filteredList);
        // ListView<String> result_list = new ListView<String>(words);

        // ObservableList<String> data;
        // data = FXCollections.observableArrayList("apple", "banana", "cherry",
        //                                          "grape", "mango", "orange", "grapefruit");
        // FilteredList<String> filteredData = new FilteredList<>(data);

        // filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> {
        //     String filterText = result_list.getText().toLowerCase();
        //     if (filterText.isEmpty()) {
        //         return p -> true;
        //     } else {
        //         return p -> p.toLowerCase().contains(filterText);
        //     }
        // }, user_enter.textProperty()));

        // result_list.setItems(filteredData);


    }
}