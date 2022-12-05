package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.*;

public class MemberController implements Initializable {

    ModelFactoryController mfc = ModelFactoryController.getInstance();
    ObservableList<Member> membersObList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));

        ExecutorService service = Executors.newFixedThreadPool(1);
        CyclicBarrier barrier = new CyclicBarrier(1);
        CyclicBarrier barrier2 = new CyclicBarrier(1);
        service.submit(()->{
            mfc.loadMembers();
            System.out.println("Loading members ");//Loading the members from the persistence
            try{
                barrier.await();
            }catch (InterruptedException | BrokenBarrierException e){
                throw new RuntimeException(e);
            }
            membersObList = mfc.fillObLiMembers();//Filling the observableList
            System.out.println("Object list ready");
            try {
                barrier2.await();
            }catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            tbMember.setItems(membersObList);//Showing the observable list in the table
            System.out.println("Show in table");
        });
    }

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtHeight;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtFilterName;
    @FXML
    private TableView<Member> tbMember;
    @FXML
    private TableColumn<Member, Integer> colAge;

    @FXML
    private TableColumn<Member, Double> colHeight;

    @FXML
    private TableColumn<Member, String> colID;

    @FXML
    private TableColumn<Member, String> colName;

    @FXML
    private TableColumn<Member, Double> colWeight;

    //Scenes
    @FXML
    void switchToExerciseScene(ActionEvent event)throws IOException {
        mfc.switchToExerciseScene(event);
    }
    @FXML
    void switchToTrainerScene(ActionEvent e) throws IOException {
        mfc.switchToTrainerScene(e);
    }
    @FXML
    void switchToSessionScene(ActionEvent e) throws IOException{
        mfc.switchToSessionScene(e);
    }

    @FXML
    public void selectMember(MouseEvent mouseEvent){
        Member member = tbMember.getSelectionModel().getSelectedItem();
        txtID.setText(member.getID());
        txtName.setText(member.getName());
        txtLastName.setText(member.getLastName());
        txtEmail.setText(member.getEmail());
        txtWeight.setText(member.getWeight()+"");
        txtWeight.setText(member.getHeight()+"");
        txtAge.setText(member.getAge()+"");
    }

    //CRUD
    @FXML
    void createMember(ActionEvent event) throws IOException {
        CompletableFuture.runAsync(()->{
            try {
                mfc.createMember(txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(),
                        txtPassword.getText(),txtWeight.getText(), txtHeight.getText(), txtAge.getText());

                membersObList.add(new Member(txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(),
                        txtPassword.getText(),Double.parseDouble(txtWeight.getText()), Double.parseDouble(txtHeight.getText()),Integer.parseInt(txtAge.getText())));

                tbMember.setItems(membersObList);
                tbMember.refresh();
                txtID.setText("");
                txtName.setText("");
                txtLastName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                txtWeight.setText("");
                txtHeight.setText("");
                txtAge.setText("");
            } catch (IOException | InputException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //Edit
    @FXML
    void btnEdit(ActionEvent event) throws InputException, IOException {
        mfc.editMember(txtID.getText(), txtName.getText(), txtLastName.getText(), txtEmail.getText(),
                txtPassword.getText(),txtWeight.getText(), txtHeight.getText(), txtAge.getText());
        membersObList = mfc.fillObLiMembers();
        tbMember.setItems(membersObList);
    }

    //Search
    @FXML
    void filterName(ActionEvent event) {
        FilteredList<Member> filteredData = new FilteredList<>(membersObList, p->true);
        tbMember.setItems(filteredData);
        mfc.searchMember(filteredData, txtFilterName);
    }

    //Delete
    @FXML
    void deleteMember(ActionEvent event) throws IOException {
        mfc.deleteMember(txtID.getText());
        membersObList = mfc.fillObLiMembers();
        tbMember.setItems(membersObList);
    }

}
