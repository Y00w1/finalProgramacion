package com.example.finalprogrmacion.resources;

import com.example.finalprogrmacion.model.*;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Persistence {
    //paths to the persistence docs
    public static final String FILE_PATH_ADMIN = "src/main/java/com/example/finalprogrmacion/resources/Admins.txt";
    public static final String FILE_PATH_MEMBERS = "src/main/java/com/example/finalprogrmacion/resources/Members.txt";
    public static final String FILE_PATH_EXERCISES = "src/main/java/com/example/finalprogrmacion/resources/Exercises.txt";
    public static final String FILE_PATH_SESSIONS = "src/main/java/com/example/finalprogrmacion/resources/Sessions.xml";
    public static final String FILE_PATH_TRAINERS = "src/main/java/com/example/finalprogrmacion/resources/Trainers.txt";

    /*Saving admins in the doc .txt
    public static void saveAdmins(HashMap<String, Admin> adminList) throws IOException{
        String content = "";
        for(Admin admin: adminList.values()){
            content += admin.getID()+","+admin.getName()+","+admin.getLastName()+","+admin.getEmail()+
                    ","+admin.getPassword()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_ADMIN, content, false);
    }*/

    //Loading the admins based on the doc .txt
    public static HashMap<String, Admin> loadAdmins() throws FileNotFoundException, IOException{

        HashMap<String, Admin> admins = new HashMap<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_ADMIN);
        String line = "";

        for (int i=0; i<content.size();i++){
            Admin myAdmin = new Admin();
            line = content.get(i);

            myAdmin.setID(line.split(",")[0]);
            myAdmin.setName(line.split(",")[1]);
            myAdmin.setLastName(line.split(",")[2]);
            myAdmin.setEmail(line.split(",")[3]);
            myAdmin.setPassword(line.split(",")[4]);

            admins.put(myAdmin.getID(), myAdmin);
        }
        return admins;
    }

    //Saving members in the doc .txt
    public static void saveMembers(HashMap<String, Member> memberList) throws IOException{
        String content = "";
        for(Member member: memberList.values()){
            content += member.getID()+","+member.getName()+","+member.getLastName()+","+member.getEmail()+
                    ","+member.getPassword()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_MEMBERS, content, false);
    }

    //Loading the members based on the doc .txt
    public static HashMap<String, Member> loadMembers() throws FileNotFoundException, IOException{

        HashMap<String, Member> members = new HashMap<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_MEMBERS);
        String line = "";

        for (int i=0; i<content.size();i++){
            Member myMember = new Member();
            line = content.get(i);

            myMember.setID(line.split(",")[0]);
            myMember.setName(line.split(",")[1]);
            myMember.setLastName(line.split(",")[2]);
            myMember.setEmail(line.split(",")[3]);
            myMember.setPassword(line.split(",")[4]);

            members.put(myMember.getID(), myMember);
        }
        return members;
    }

    //Saving exercises in the doc .txt
    public static void saveExercises(HashMap<String, Exercise> exerciseList) throws IOException{
        String content = "";
        for( Exercise exercise : exerciseList.values()){
            content += exercise.getId()+","+exercise.getName()+","+exercise.getCalories()+","+exercise.getDuration()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_EXERCISES, content, false);
    }

    //Loading the exercises from the doc .txt
    public static HashMap<String, Exercise> loadExercises() throws FileNotFoundException, IOException{
        HashMap<String, Exercise> exercises = new HashMap<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_EXERCISES);
        String line = "";

        for (int i = 0; i < content.size(); i++){
            Exercise myExercise = new Exercise();
            line = content.get(i);

            myExercise.setId(line.split(",")[0]);
            myExercise.setName(line.split(",")[1]);
            myExercise.setCalories(Double.parseDouble(line.split(",")[2]));
            myExercise.setDuration(Double.parseDouble(line.split(",")[3]));

            exercises.put(myExercise.getId(), myExercise);
        }
        return exercises;
    }

    //Saving Trainers in the doc .txt
    public static void saveTrainers(HashMap<String, Trainer> trainerList) throws IOException {
        String content = "";
        for (Trainer trainer : trainerList.values()) {
            content += trainer.getID()+","+trainer.getName()+","+trainer.getLastName()+","+trainer.getEmail()+
                    ","+trainer.getPassword()+","+trainer.getMonths()+","+trainer.getSalary()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_TRAINERS, content, false);
    }

    //Loading the Trainers from the doc .txt
    public static HashMap<String, Trainer> loadTrainers() throws FileNotFoundException, IOException{
        HashMap<String, Trainer> trainers = new HashMap<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_TRAINERS);
        String line = "";

        for (int i = 0; i < content.size(); i++){
            Trainer myTrainer = new Trainer();
            line = content.get(i);

            myTrainer.setID(line.split(",")[0]);
            myTrainer.setName(line.split(",")[1]);
            myTrainer.setLastName(line.split(",")[2]);
            myTrainer.setEmail(line.split(",")[3]);
            myTrainer.setPassword(line.split(",")[4]);
            myTrainer.setMonths(Integer.parseInt(line.split(",")[5]));
            myTrainer.setSalary(Double.parseDouble(line.split(",")[6]));

            trainers.put(myTrainer.getID(), myTrainer);
        }
        return trainers;
    }

    //Saving Session in the doc .xml
    public static void saveSessionsXMLResource(SessionPer session){
        try{
            UtilDoc.saveXMLSerializedResource(FILE_PATH_SESSIONS, session);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //Loading the Sessions from the doc .xml
    public static SessionPer loadSessionsXMLResource(){
        SessionPer session = null;
        try{
            session = (SessionPer) UtilDoc.loadXMLSerializedResource(FILE_PATH_SESSIONS);
        }catch(Exception e){
            System.out.println(""+e);
            e.printStackTrace();
        }
        return session;
    }

}
