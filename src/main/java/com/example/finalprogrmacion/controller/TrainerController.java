package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TrainerController implements Initializable {
    @FXML
    private TableColumn<Trainer, String> colID;

    @FXML
    private TableColumn<Trainer, Integer> colMonths;

    @FXML
    private TableColumn<Trainer, String> colName;

    @FXML
    private TableColumn<Trainer, Double> colSalary;

    @FXML
    private TableView<Trainer> tbTrainer;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFilterName;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMonths;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtSalary;

    //Scenes
    @FXML
    void switchToExerciseScene(ActionEvent event) throws IOException {
        mfc.switchToExerciseScene(event);
    }

    @FXML
    void switchToMemberScene(ActionEvent event) throws IOException {
        mfc.switchToMemberScene(event);
    }

    @FXML
    void switchToSessionScene(ActionEvent event) throws IOException {
        mfc.switchToSessionScene(event);
    }

    //
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    ObservableList<Trainer> trainersObList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMonths.setCellValueFactory(new PropertyValueFactory<>("months"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ExecutorService service = Executors.newFixedThreadPool(1);
        CyclicBarrier barrier = new CyclicBarrier(1);
        CyclicBarrier barrier2 = new CyclicBarrier(1);
        service.submit(()->{
           mfc.loadTrainers();
            System.out.println("Loading trainers");
            try{
                barrier.await();
            }catch (InterruptedException | BrokenBarrierException e){
                throw new RuntimeException(e);
            }
            trainersObList = mfc.fillObLiTrainers();
            System.out.println("Filling observable list");
            try {
                barrier2.await();
            }catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            tbTrainer.setItems(trainersObList);
            System.out.println("Updating table");
        });
    }

    //
    @FXML
    void createTrainer(ActionEvent event) throws InputException, IOException {
        mfc.createTrainer(txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(), txtPassword.getText(), txtMonths.getText(), txtSalary.getText());
        trainersObList.add(new Trainer( txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(), txtPassword.getText(),Integer.parseInt(txtMonths.getText()), Double.parseDouble(txtSalary.getText()) ));
        tbTrainer.setItems(trainersObList);
        txtID.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtMonths.setText("");
        txtSalary.setText("");
    }

    @FXML
    void deleteTrainer(ActionEvent event) throws IOException {
        mfc.deleteTrainer(txtID.getText());
        trainersObList = mfc.fillObLiTrainers();
        tbTrainer.setItems(trainersObList);
        txtID.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtMonths.setText("");
        txtSalary.setText("");
    }

    @FXML
    void editTrainer(ActionEvent event) throws InputException, IOException {
        mfc.editTrainer(txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(), txtPassword.getText(), txtMonths.getText(), txtSalary.getText());
        trainersObList = mfc.fillObLiTrainers();
        tbTrainer.setItems(trainersObList);
        txtID.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtMonths.setText("");
        txtSalary.setText("");
    }

    @FXML
    void filterName(ActionEvent event) {
        FilteredList<Trainer> filteredTrainers = new FilteredList<>( trainersObList ,p->true);
        tbTrainer.setItems(filteredTrainers);
        mfc.sortTrainer(filteredTrainers, txtFilterName);
    }

    @FXML
    void selectTrainer(MouseEvent event) {
        Trainer trainer = tbTrainer.getSelectionModel().getSelectedItem();
        txtID.setText(trainer.getID());
        txtName.setText(trainer.getName());
        txtLastName.setText(trainer.getLastName());
        txtEmail.setText(trainer.getEmail());
        txtMonths.setText(trainer.getMonths()+"");
        txtSalary.setText(trainer.getSalary()+"");
    }
}
