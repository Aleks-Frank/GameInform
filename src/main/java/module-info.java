module com.example.infogames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires org.apache.poi.ooxml;


    opens com.example.infogames to javafx.fxml;
    exports com.example.infogames;
    exports com.example.infogames.controllers;
    opens com.example.infogames.controllers to javafx.fxml;
}