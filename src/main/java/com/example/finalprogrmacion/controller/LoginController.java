package com.example.finalprogrmacion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

public class LoginController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CompletableFuture.runAsync(()->mfc.loadAdmins());
    }
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;
    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUser;

    @FXML
    void validateLogin(ActionEvent event) throws IOException {
        if(mfc.verifyCredentials(txtUser.getText(), txtPassword.getText())){
            mfc.switchToLandingScene(event);
        }else{
            lblUser.setText("Datos inválidos");
            lblPassword.setText("Datos inválidos");
        }
    }
}
