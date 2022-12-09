package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.*;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.notFoundExc;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SessionService {
    //Persistence
    void loadSessions();
    //List for the tables
    //Sessions
    ObservableList<Session> fillObLiSessions();
    //Exercises
    ObservableList<Exercise> fillObLiExercises();
    //Members
    ObservableList<Member> fillObLiMembers();
    //Fill both sublist
    void fillSubLists(Session session, ObservableList<Exercise> exercises, ObservableList<Member> members);
    void resetSubList();

    void setSessionsPer(SessionPer sessionsPer);
    HashMap<String, Exercise> getExercisesSession();
    HashMap<String, Member> getMembersSession();

    //Functions to fill and remove the exercises and members arrays
    void addExercise(String IDExercise, Exercise exerciseVal) throws InputException, notFoundExc;
    void removeExercise(String IDExercise) throws InputException, notFoundExc;
    void addMember(String IDMember, Member member) throws InputException, notFoundExc;
    void removeMember(String IDMember) throws InputException, notFoundExc;

    //CRUD Session
    Session createSession(String name, String trainerID, LocalDate date, String timeStart, String timeEnd, Trainer trainer) throws InputException, IOException, notFoundExc;
    void editSession(Integer id, String name, String trainerID, LocalDate date, String timeStart, String timeEnd, Trainer trainer) throws InputException, IOException, notFoundExc;
    void deleteSession(Integer ID) throws InputException;
    void sortSessions(FilteredList<Session> filteredList, TextField textField);
}
