package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
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
    void fillSubLists(Session session);

    HashMap<String, Exercise> getExercisesSession();
    HashMap<String, Member> getMembersSession();

    //Functions to fill and remove the exercises and members arrays
    void addExercise(String IDExercise) throws InputException, notFoundExc;
    void removeExercise(String IDExercise) throws InputException, notFoundExc;
    void addMember(String IDMember) throws InputException, notFoundExc;
    void removeMember(String IDMember) throws InputException, notFoundExc;

    //CRUD Session
    void createSession(String name, String trainerID, LocalDate date, String time) throws InputException, IOException, notFoundExc;
    void editSession(Integer id, String name, String trainerID, LocalDate date, String time) throws InputException, IOException, notFoundExc;
    void deleteSession(Integer ID) throws InputException;
    void sortSessions(FilteredList<Session> filteredList, TextField textField);
}
