package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.controller.ModelFactoryController;
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
    //private final ClassVal classVal = new ClassVal();

    //Lists
    HashMap<Integer, Session> sessions = new HashMap<>();
    HashMap<String, Exercise> exercisesSession = new HashMap<>();
    HashMap<String, Member> membersSession = new HashMap<>();

    //PERSISTENCE
    SessionPer sessionsPer;
    public SessionPer getSessionsPer() {
        return sessionsPer;
    }

    public void setSessionsPer(SessionPer sessionsPer) {
        this.sessionsPer = sessionsPer;
    }

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
        /*for(Session session : sessionsPer.getSessions().values()){
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
    public void addExercise(String IDExercise, Exercise exerciseVal) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDExercise);
        exercisesSession.put(IDExercise, exerciseVal);
    }

    @Override
    public void removeExercise(String IDExercise) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDExercise);
        exercisesSession.remove(IDExercise);
    }

    //MEMBERS
    @Override
    public void addMember(String IDMember, Member member) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDMember);
        membersSession.put(IDMember, member);
    }

    @Override
    public void removeMember(String IDMember) throws InputException, notFoundExc {
        inpVal.txtEmpty(IDMember);
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
    public Session createSession(String name, String trainerID, LocalDate date, String timeStart, String timeEnd, Trainer trainer) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, timeStart, timeEnd);
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
        HashMap<String, Exercise> auxExercisesSession = exercisesSession;
        HashMap<String, Member> auxMembersSession = membersSession;
        Session session = new Session(ID, name, trainer, auxExercisesSession, auxMembersSession, date, time);
        //System.out.println(auxMembersSession.size() +" - "+ auxExercisesSession.size() );
        //sessionsPer.getSessions().put(ID,session);
        sessions.put(ID, session);
        Persistence.saveSessionsXMLResource(sessionsPer);
        resetSubList();
        return session;
    }
    private void resetSubList(){
        exercisesSession.clear();
        membersSession.clear();
    }

    @Override
    public void editSession(Integer id, String name, String trainerID, LocalDate date, String timeStart, String timeEnd, Trainer trainer) throws InputException, IOException, notFoundExc {
        inpVal.emptySession(name, trainerID, date, timeStart, timeEnd);
        String time = inpVal.validTime(timeStart, timeEnd);
        //inpVal.uniqueTime(time, date, sessions);

        sessions.replace(id, new Session(id, name, trainer, exercisesSession, membersSession, date, time));
        Persistence.saveSessionsXMLResource(sessionsPer);
        exercisesSession.clear();
        membersSession.clear();
    }

    @Override
    public void deleteSession(Integer ID) throws InputException {
        inpVal.txtEmpty(ID+"");
        sessions.remove(ID);
        Persistence.saveSessionsXMLResource(sessionsPer);
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
