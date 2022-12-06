package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.notFoundExc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class SessionController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    ObservableList<Session> sessionsOb = FXCollections.observableArrayList();
    ObservableList<Member> membersOb = FXCollections.observableArrayList();
    ObservableList<Exercise> exercisesOb = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cbTime;
    @FXML
    private TableColumn<Session, LocalDate> colDate;
    @FXML
    private TableColumn<Exercise, String> colIDExercise;
    @FXML
    private TableColumn<Member, String> colIDMember;
    @FXML
    private TableColumn<Session, String> colName;
    @FXML
    private TableColumn<Exercise, String> colNameExercise;
    @FXML
    private TableColumn<Member, String> colNameMember;
    @FXML
    private TableColumn<Session, LocalTime> colTime;
    @FXML
    private TableColumn<Session, String> colTrainer;
    @FXML
    private DatePicker inpDate;
    @FXML
    private TableView<Exercise> tbExercise;
    @FXML
    private TableView<Member> tbMember;
    @FXML
    private TableView<Session> tbSession;
    @FXML
    private TextField txtExercise;
    @FXML
    private TextField txtFilterName;
    @FXML
    private TextField txtMember;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTrainer;

    //Scenes
    @FXML
    void switchToExercise(ActionEvent event) throws IOException {
        mfc.switchToExerciseScene(event);
    }
    @FXML
    void switchToMember(ActionEvent event) throws IOException {
        mfc.switchToMemberScene(event);
    }
    @FXML
    void switchToTrainer(ActionEvent event) throws IOException {
        mfc.switchToTrainerScene(event);
    }

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //EXERCISES
    @FXML
    void addExercise(ActionEvent event) throws InputException, notFoundExc {
        mfc.addExercise(txtExercise.getText());
    }
    @FXML
    void removeExercise(ActionEvent event) throws InputException, notFoundExc {
        mfc.removeExercise(txtExercise.getText());
    }
    //MEMBERS
    @FXML
    void addMember(ActionEvent event) throws InputException, notFoundExc {
        mfc.addMember(txtMember.getText());
    }
    @FXML
    void removeMember(ActionEvent event) throws InputException, notFoundExc {
        mfc.removeMember(txtMember.getText());
    }

    //CRUD SESSIONS
    @FXML
    void createSession(ActionEvent event) {

    }
    @FXML
    void deleteSession(ActionEvent event) {

    }
    @FXML
    void editSession(ActionEvent event) {

    }
    @FXML
    void sortByName(ActionEvent event) {

    }

    //Table selections
    @FXML
    void selectTbExercise(MouseEvent event) {

    }

    @FXML
    void selectTbMember(MouseEvent event) {

    }

    @FXML
    void selectTbSession(MouseEvent event) {

    }

}
