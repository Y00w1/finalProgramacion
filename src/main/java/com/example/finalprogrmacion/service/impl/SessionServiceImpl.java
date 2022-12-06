package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.*;
import com.example.finalprogrmacion.resources.Persistence;
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

    //PERSISTENCE
    //SessionPer sessionsPer = Persistence.loadSessionsXMLResource();

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
        /*SessionPer sessionsPer = Persistence.loadSessionsXMLResource();
        for(Session session : sessionsPer.getSessions().values()){
            sessions.put(session.getID(), session);
        }*/
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
    public void fillSubLists(Session session, ObservableList<Exercise> exercises, ObservableList<Member> members){
        membersSession = session.getMembers();
        members.addAll(membersSession.values());
        exercisesSession = session.getExercises();
        exercises.addAll(exercisesSession.values());
    }

    //CRUD Session
    @Override
    public Session createSession(String name, String trainerID, LocalDate date, String timeStart, String timeEnd) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, timeStart, timeEnd);
        Trainer trainer = classVal.valIDTrainer(trainerID);
        String time = inpVal.validTime(timeStart, timeEnd);
        inpVal.uniqueTime(time, date, sessions);

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
        Session session = new Session(ID, name, trainer, exercisesSession, membersSession, date, time);
        sessions.put(ID, session);
        exercisesSession.clear();
        membersSession.clear();
        /*sessionsPer.getSessions().put(ID, session);
        Persistence.saveSessionsXMLResource(sessionsPer);*/
        return session;
    }

    @Override
    public void editSession(Integer id, String name, String trainerID, LocalDate date, String timeStart, String timeEnd) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, timeStart, timeEnd);
        String time = inpVal.validTime(timeStart, timeEnd);
        inpVal.uniqueTime(time, date, sessions);
        Trainer trainer = classVal.valIDTrainer(trainerID);

        sessions.replace(id, new Session(id, name, trainer, exercisesSession, membersSession, date, time));
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
