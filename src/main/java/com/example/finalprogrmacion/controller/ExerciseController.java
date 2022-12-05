package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Exercise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ExerciseController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    ObservableList<Exercise> exercisesObList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

