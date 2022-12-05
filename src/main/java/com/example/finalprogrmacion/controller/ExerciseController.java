package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.InputsVal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExerciseController implements Initializable {
    @FXML
    private TableColumn<Exercise, Double> colCalories;
    @FXML
    private TableColumn<Exercise, Double> colDuration;
    @FXML
    private TableColumn<Exercise, String> colID;
    @FXML
    private TableColumn<Exercise, String> colName;
    @FXML
    private TableView<Exercise> tbExer;
    @FXML
    private TextField txtCalories;
    @FXML
    private TextField txtDuration;
    @FXML
    private TextField txtFilerName;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtName;

    //
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    ObservableList<Exercise> exercisesObList = FXCollections.observableArrayList();
    private final InputsVal inpVal = new InputsVal();

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        ExecutorService service = Executors.newFixedThreadPool(1);
        CyclicBarrier barrier = new CyclicBarrier(1);
        CyclicBarrier barrier2 = new CyclicBarrier(1);
        service.submit(()->{
           mfc.loadExercises();
            System.out.println("Loading Exercises");
            try{
                barrier.await();
            }catch (InterruptedException | BrokenBarrierException e){
                throw new RuntimeException(e);
            }
            exercisesObList = mfc.fillObLiExercises();
            System.out.println("Filling observable list");
            try {
                barrier2.await();
            }catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            tbExer.setItems(exercisesObList);
            System.out.println("Updating table");
        });
    }

    //Scenes
    @FXML
    void switchToMemberScene(ActionEvent event) throws IOException {
        mfc.switchToMemberScene(event);
    }

    @FXML
    void switchToSessionScene(ActionEvent event) throws IOException {
        mfc.switchToSessionScene(event);
    }

    @FXML
    void switchToTrainerScene(ActionEvent event) throws IOException {
        mfc.switchToTrainerScene(event);
    }

    //CRUD
    //Create
    @FXML
    void createExer(ActionEvent event) throws InputException, IOException {
        mfc.createExercise(txtID.getText(), txtName.getText(), txtCalories.getText(), txtDuration.getText());
        exercisesObList.add( new Exercise( txtID.getText(), txtName.getText(),Double.parseDouble(txtCalories.getText()), Double.parseDouble(txtDuration.getText()) ) );
        tbExer.setItems(exercisesObList);
        txtID.setText("");
        txtName.setText("");
        txtDuration.setText("");
        txtCalories.setText("");
    }
    //Delete
    @FXML
    void deleteExer(ActionEvent event) throws IOException {
        mfc.deleteExercise(txtID.getText());
        exercisesObList = mfc.fillObLiExercises();
        tbExer.setItems(exercisesObList);
        txtID.setText("");
        txtName.setText("");
        txtDuration.setText("");
        txtCalories.setText("");
    }
    //Edit
    @FXML
    void editExer(ActionEvent event) throws InputException, IOException {
        mfc.editExercise(txtID.getText(), txtName.getText(), txtCalories.getText(), txtDuration.getText());
        exercisesObList = mfc.fillObLiExercises();
        tbExer.setItems(exercisesObList);
    }
    //Search
    @FXML
    void filterName(ActionEvent event) {
        FilteredList<Exercise> filteredExercises = new FilteredList<>(exercisesObList, p->true);
        tbExer.setItems(filteredExercises);
        mfc.sortExercise(filteredExercises, txtFilerName);
    }

    //Select
    @FXML
    void selectedExer(MouseEvent event) {
        Exercise exercise = tbExer.getSelectionModel().getSelectedItem();
        txtID.setText(exercise.getId());
        txtName.setText(exercise.getName());
        txtCalories.setText(exercise.getCalories()+"");
        txtDuration.setText(exercise.getDuration()+"");
    }
}

