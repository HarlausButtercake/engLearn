module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Controller;
    opens com.example.demo.Controller to javafx.fxml;
}