package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.service.SessionService;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.InputsVal;
import com.example.finalprogrmacion.validator.ClassVal;
import com.example.finalprogrmacion.validator.notFoundExc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class SessionServiceImpl implements SessionService {
    //Validators
    private final InputsVal inpVal = new InputsVal();
    private final ClassVal classVal = new ClassVal();

    //Lists
    HashMap<Integer, Session> sessions = new HashMap<>();
    HashMap<String, Exercise> exercisesSession = new HashMap<>();
    HashMap<String, Member> membersSession = new HashMap<>();

    //Getter for validations
    @Override
    public HashMap<String, Exercise> getExercisesSession() {
        return exercisesSession;
    }
    @Override
    public HashMap<String, Member> getMembersSession() {
        return membersSession;
    }

    //Persistence
    @Override
    public void loadSessions() {

    }
    //List for the tables
    //Sessions
    @Override
    public ObservableList<Session> fillObLiSessions() {
        ObservableList<Session> sessionsObList = FXCollections.observableArrayList();
        sessionsObList.addAll(sessions.values());
        return sessionsObList;
    }
    //Exercises
    @Override
    public ObservableList<Exercise> fillObLiExercises(){
        ObservableList<Exercise> exercisesObList = FXCollections.observableArrayList();
        exercisesObList.addAll(exercisesSession.values());
        return exercisesObList;
    }
    //Members
    @Override
    public ObservableList<Member> fillObLiMembers(){
        ObservableList<Member> membersObList = FXCollections.observableArrayList();
        membersObList.addAll(membersSession.values());
        return membersObList;
    }


    //Functions to fill and remove the exercises and members arrays
    //EXERCISES
    @Override
    public void addExercise(String IDExercise) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDExercise);
        Exercise exercise = classVal.valIDExercise(IDExercise);
        exercisesSession.put(IDExercise, exercise);
    }

    @Override
    public void removeExercise(String IDExercise) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDExercise);
        classVal.calIDExerSession(IDExercise);
        exercisesSession.remove(IDExercise);
    }

    //MEMBERS
    @Override
    public void addMember(String IDMember) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDMember);
        Member member = classVal.valIDMember(IDMember);
        membersSession.put(IDMember, member);
    }

    @Override
    public void removeMember(String IDMember) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDMember);
        classVal.valIDMmembSession(IDMember);
        membersSession.remove(IDMember);
    }
    //FILL EXERCISE AND MEMBER
    @Override
    public void fillSubLists(Session session){
        membersSession = session.getMembers();
        exercisesSession = session.getExercises();
    }

    //CRUD Session
    @Override
    public void createSession(String name, String trainerID, LocalDate date, String time) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, time);
        Trainer trainer = classVal.valIDTrainer(trainerID);

        Integer ID;
        if(!sessions.isEmpty()){
            Integer max = 1;
            for(Session session : sessions.values()){
                if (session.getID() > max){
                    max = session.getID();
                }
            }
            ID = max;
        }else{
            ID = 0;
        }
        ID++;
        sessions.put(ID, new Session(ID, name, trainer, exercisesSession, membersSession, date, LocalTime.parse(time)));
        exercisesSession.clear();
        membersSession.clear();
    }

    @Override
    public void editSession(Integer id, String name, String trainerID, LocalDate date, String time) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, time);
        Trainer trainer = classVal.valIDTrainer(trainerID);
        sessions.replace(id, new Session(id, name, trainer, exercisesSession, membersSession, date, LocalTime.parse(time)));
        exercisesSession.clear();
        membersSession.clear();
    }

    @Override
    public void deleteSession(Integer ID) throws InputException {
        inpVal.txtEmpty(ID+"");
        sessions.remove(ID);
    }
    @Override
    public void sortSessions(FilteredList<Session> filteredList, TextField textField) {
        textField.textProperty().addListener((prop, old, text)->{
            filteredList.setPredicate(element ->{
                if (text == null || text.isEmpty()) return true;
                String name = element.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
    }
}
