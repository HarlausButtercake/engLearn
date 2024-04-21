module com.example.englearngui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.englearngui to javafx.fxml;
    exports com.example.englearngui;
}
