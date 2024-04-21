module com.example.englearngui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.example.englearngui to javafx.fxml;
    exports com.example.englearngui;
}
