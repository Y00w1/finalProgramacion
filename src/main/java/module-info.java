module com.example.finalprogrmacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.finalprogrmacion to javafx.fxml;
    opens com.example.finalprogrmacion.controller to javafx.fxml;
    opens com.example.finalprogrmacion.model to javafx.base;
    exports com.example.finalprogrmacion;
}