package com.example.demo.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DumbController {
    @FXML
    private ListView<String> wawa;

    @FXML
    void initialize() {
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");

        wawa.setItems(names);
    }
}
