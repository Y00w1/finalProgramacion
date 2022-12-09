package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.*;
import com.example.finalprogrmacion.service.ModelFactoryControllerService;
import com.example.finalprogrmacion.service.impl.GymServiceImpl;
import com.example.finalprogrmacion.validator.ClassVal;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.notFoundExc;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class ModelFactoryController implements ModelFactoryControllerService {
    GymServiceImpl gymService;
    public GymServiceImpl getGymService() {
        return gymService;
    }

    private static class SingletonHolder{
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance(){
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        gymService = new GymServiceImpl();
    }

    // create class for Validations
    private final ClassVal classVal = new ClassVal();

    //Functions

    //Scenes buttons
    //Landing
    public void switchToLandingScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToLandingScene(event);
    }
    //Exercise
    public void switchToExerciseScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToExerciseScene(event);
    }
    //Member
    public void switchToMemberScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToMemberScene(event);
    }
    //Trainer
    public void switchToTrainerScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToTrainerScene(event);
    }
    //Session
    public void switchToSessionScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToSessionScene(event);
    }

    //Login
    public void loadAdmins(){
        gymService.getLoginService().loadAdmins();
    }
    public Boolean verifyCredentials(String username, String password){
        return gymService.getLoginService().verifyCredentials(username, password);
    }

    //Members
    //Create
    public void createMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException {
        gymService.getMemberService().addMember(ID, name, lastName, email, password, weight, height, age);
    }
    //Delete
    public void deleteMember(String ID) throws IOException {
        gymService.getMemberService().deleteMember(ID);
    }
    //Edit
    public void editMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws InputException, IOException {
        gymService.getMemberService().editMember(ID, name, lastName, email, password, weight, height, age);
    }
    public void loadMembers(){
        gymService.getMemberService().loadMembers();
    }
    //Sort
    public void searchMember(FilteredList<Member> filteredList, TextField textField){
        gymService.getMemberService().sortByName(filteredList, textField);
    }
    //Filling the observableList
    public ObservableList<Member> fillObLiMembers(){
        return gymService.getMemberService().fillObLiMembers();
    }

    //Exercises
    //Fill the Observable List
    public ObservableList<Exercise> fillObLiExercises(){
        return gymService.getExerciseService().fillObLiExercises();
    }

    //Persistence
    //Load
    public void loadExercises(){
        gymService.getExerciseService().loadExercises();
    }

    //CRUD
    //Create
    public void createExercise(String id, String name, String calories, String duration) throws InputException, IOException {
        gymService.getExerciseService().createExercise(id, name, calories, duration);
    }
    //Edit
    public void editExercise(String id, String name, String calories, String duration) throws InputException, IOException {
        gymService.getExerciseService().editExercise(id, name, calories, duration);
    }

    //Delete
    public void deleteExercise(String id) throws IOException {
        gymService.getExerciseService().deleteExercise(id);
    }

    //Search
    public void sortExercise(FilteredList<Exercise> filteredList, TextField textField){
        gymService.getExerciseService().sortExercise(filteredList, textField);
    }

    //TRAINERS

    //OBSERVABLE LIST
    @Override
    public ObservableList<Trainer> fillObLiTrainers() {
        return gymService.getTrainerService().fillObLiTrainers();
    }

    //PERSISTENCE
    @Override
    public void loadTrainers() {
        gymService.getTrainerService().loadTrainers();
    }

    //CRUD
    //CREATE
    @Override
    public void createTrainer(String ID, String name, String lastName, String email, String password, String months, String salary) throws InputException, IOException {
        gymService.getTrainerService().createTrainer(ID, name, lastName, email, password, months, salary);
    }
    //EDIT
    @Override
    public void editTrainer(String ID, String name, String lastName, String email, String password, String months, String salary) throws InputException, IOException {
        gymService.getTrainerService().editTrainer(ID, name, lastName, email, password, months, salary);
    }
    //DELETE
    @Override
    public void deleteTrainer(String ID) throws IOException {
        gymService.getTrainerService().deleteTrainer(ID);
    }
    //SORT
    @Override
    public void sortTrainer(FilteredList<Trainer> filteredList, TextField textField) {
        gymService.getTrainerService().sortTrainer(filteredList, textField);
    }


    //SESSION
    //Persistence
    public void loadSessions(){
        gymService.getSessionService().loadSessions();
    }

    //validations
    //Exercises
    public Exercise IDExerciseVal(String IDexercise) throws notFoundExc {
        return classVal.valIDExercise(IDexercise, gymService.getExerciseService().getExercises());
    }

    //Members
    public Member valIDMember(String id) throws notFoundExc {
        return classVal.valIDMember(id, gymService.getMemberService().getMembersHashMap());
    }

    //Lists for the tables
    //Sessions
    public ObservableList<Session> fillObSessions(){
        return gymService.getSessionService().fillObLiSessions();
    }

    //Functions to fill and remove the exercises and members arrays
    //EXERCISES
    public void addExercise(String IDExercise) throws InputException, notFoundExc{
        Exercise exerciseVal = classVal.valIDExercise(IDExercise, gymService.getExerciseService().getExercises());
        gymService.getSessionService().addExercise(IDExercise, exerciseVal);
    }
    public void removeExercise(String IDExercise) throws InputException, notFoundExc{
        classVal.valIDExerSession(IDExercise, gymService.getExerciseService().getExercises());
        gymService.getSessionService().removeExercise(IDExercise);
    }

    //MEMBERS
    public void addMember(String IDMember) throws InputException, notFoundExc{
        Member memberVal = classVal.valIDMember(IDMember, gymService.getMemberService().getMembersHashMap());
        gymService.getSessionService().addMember(IDMember, memberVal);
    }
    public void removeMember(String IDMember) throws InputException, notFoundExc{
        classVal.valIDMembSession(IDMember, gymService.getMemberService().getMembersHashMap());
        gymService.getSessionService().removeMember(IDMember);
    }
    //FILL EXERCISE AND MEMBER
    public void fillSubLists(Session session, ObservableList<Exercise> exercises, ObservableList<Member> members){
        gymService.getSessionService().fillSubLists(session, exercises, members);
    }
    //clear subLists
    public void resetSubList(){
        gymService.getSessionService().resetSubList();
    }

    //CRUD Session
    public Session createSession(String name, String trainerID, LocalDate date, String timeStart, String timeEnd) throws InputException, IOException, notFoundExc{
        Trainer trainer = classVal.valIDTrainer(trainerID, gymService.getTrainerService().getTrainers());
        return gymService.getSessionService().createSession(name, trainerID, date, timeStart, timeEnd, trainer);
    }
    //
    public void editSession(Integer id, String name, String trainerID, LocalDate date, String timeStart, String timeEnd) throws InputException, IOException, notFoundExc{
        Trainer trainer = classVal.valIDTrainer(trainerID, gymService.getTrainerService().getTrainers());
        gymService.getSessionService().editSession(id, name, trainerID, date, timeStart, timeEnd, trainer);
    }
    //load
    public void setSessionsPer(SessionPer sessionsPer){
        gymService.getSessionService().setSessionsPer(sessionsPer);
    }
    //
    public void deleteSession(Integer ID) throws InputException{
        gymService.getSessionService().deleteSession(ID);
    }
    //
    public void sortSessions(FilteredList<Session> filteredList, TextField textField){
        gymService.getSessionService().sortSessions(filteredList, textField);
    }

}
