package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.model.SessionPer;
import com.example.finalprogrmacion.resources.Persistence;
import com.example.finalprogrmacion.validator.ClassVal;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.notFoundExc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class SessionController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    SessionPer sessionsPer = new SessionPer();
    ObservableList<Session> sessionsOb = FXCollections.observableArrayList();
    ObservableList<Member> membersOb = FXCollections.observableArrayList();
    ObservableList<Exercise> exercisesOb = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cbTimeEnd;
    @FXML
    private ComboBox<String> cbTimeStart;
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

    //ComboBox
    String[] time = {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};
    ObservableList<String> obLiTime = FXCollections.observableArrayList();

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTrainer.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("day"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        colIDMember.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNameMember.setCellValueFactory(new PropertyValueFactory<>("name"));

        colIDExercise.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameExercise.setCellValueFactory(new PropertyValueFactory<>("name"));

        sessionsPer = Persistence.loadSessionsXMLResource();
        mfc.setSessionsPer(sessionsPer);

        obLiTime.addAll(time);
        cbTimeStart.setItems(obLiTime);
        cbTimeEnd.setItems(obLiTime);

        mfc.loadSessions();
        sessionsOb = mfc.fillObSessions();
        tbSession.setItems(sessionsOb);
    }

    //EXERCISES
    @FXML
    void addExercise(ActionEvent event) throws InputException, notFoundExc {
        mfc.addExercise(txtExercise.getText());
        Exercise exercise = mfc.IDExerciseVal(txtExercise.getText());
        exercisesOb.add(exercise);
        tbExercise.setItems(exercisesOb);
    }
    @FXML
    void removeExercise(ActionEvent event) throws InputException, notFoundExc {
        mfc.removeExercise(txtExercise.getText());
        Exercise exercise = mfc.IDExerciseVal(txtExercise.getText());
        exercisesOb.remove(exercise);
        tbExercise.setItems(exercisesOb);
    }
    //MEMBERS
    @FXML
    void addMember(ActionEvent event) throws InputException, notFoundExc {
        mfc.addMember(txtMember.getText());
        Member member = mfc.valIDMember(txtMember.getText());
        membersOb.add(member);
        tbMember.setItems(membersOb);
    }
    @FXML
    void removeMember(ActionEvent event) throws InputException, notFoundExc {
        mfc.removeMember(txtMember.getText());
        Member member = mfc.valIDMember(txtMember.getText());
        membersOb.remove(member);
        tbMember.setItems(membersOb);
    }

    //CRUD SESSIONS
    @FXML
    void createSession(ActionEvent event) throws InputException, notFoundExc, IOException {
        Session session = mfc.createSession(txtName.getText(), txtTrainer.getText(), inpDate.getValue(), cbTimeStart.getValue(), cbTimeEnd.getValue());
        sessionsOb.add(session);
        tbSession.setItems(sessionsOb);
        txtName.setText("");
        txtTrainer.setText("");
        txtMember.setText("");
        txtExercise.setText("");
        exercisesOb.clear();
        membersOb.clear();
        tbExercise.setItems(exercisesOb);
        tbMember.setItems(membersOb);
    }
    @FXML
    void deleteSession(ActionEvent event) throws InputException, notFoundExc, IOException {
        Session session = tbSession.getSelectionModel().getSelectedItem();
        mfc.deleteSession(session.getID());
        sessionsOb.remove(session);
        tbSession.setItems(sessionsOb);
        txtName.setText("");
        txtTrainer.setText("");
        txtMember.setText("");
        txtExercise.setText("");
        exercisesOb.clear();
        membersOb.clear();
        tbExercise.setItems(exercisesOb);
        tbMember.setItems(membersOb);
    }
    @FXML
    void editSession(ActionEvent event) throws InputException, notFoundExc, IOException {
        Session session = tbSession.getSelectionModel().getSelectedItem();
        mfc.editSession(session.getID(), txtName.getText(), txtTrainer.getText(), inpDate.getValue(), cbTimeStart.getValue(), cbTimeEnd.getValue());
        exercisesOb.clear();
        membersOb.clear();
        tbExercise.setItems(exercisesOb);
        tbMember.setItems(membersOb);
    }
    @FXML
    void sortByName(ActionEvent event) {
        FilteredList<Session> filteredList = new FilteredList<Session>(sessionsOb, p->true);
        tbSession.setItems(filteredList);
        mfc.sortSessions(filteredList, txtFilterName);
    }

    //Table selections
    @FXML
    void selectTbExercise(MouseEvent event) {
        Exercise exercise = tbExercise.getSelectionModel().getSelectedItem();
        txtExercise.setText(exercise.getId());
    }

    @FXML
    void selectTbMember(MouseEvent event) {
        Member member = tbMember.getSelectionModel().getSelectedItem();
        txtMember.setText(member.getID());
    }

    @FXML
    void selectTbSession(MouseEvent event) {
        Session session = tbSession.getSelectionModel().getSelectedItem();
        txtName.setText(session.getName());
        txtTrainer.setText(session.getTrainer().getID());
        exercisesOb.clear();
        membersOb.clear();
        mfc.fillSubLists(session, exercisesOb, membersOb);
        tbExercise.setItems(exercisesOb);
        tbMember.setItems(membersOb);
    }

    @FXML
    void clearSubLists(MouseEvent event) {
        mfc.resetSubList();
    }

}
