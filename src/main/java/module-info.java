module com.example.finalprogrmacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.finalprogrmacion to javafx.fxml;
    opens com.example.finalprogrmacion.controller to javafx.fxml;
    exports com.example.finalprogrmacion;
}