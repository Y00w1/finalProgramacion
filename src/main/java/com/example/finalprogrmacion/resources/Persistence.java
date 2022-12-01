package com.example.finalprogrmacion.resources;

import com.example.finalprogrmacion.model.Admin;
import com.example.finalprogrmacion.model.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
    //paths to the persistence docs
    public static final String FILE_PATH_ADMIN = "./Admins.txt";
    public static final String FILE_PATH_MEMBERS = "./Members.txt";
    public static final String FILE_PATH_EXERCISES = "./Exercises.txt";
    public static final String FILE_PATH_SESSIONS = "./Sessions.txt";
    public static final String FILE_PATH_TRAINERS = "./Trainers.txt";

    //Saving admins in the doc .txt
    public static void saveAdmins(ArrayList<Admin> adminList) throws IOException{
        String content = "";
        for(Admin admin: adminList){
            content += admin.getID()+","+admin.getName()+","+admin.getLastName()+","+admin.getEmail()+
                    ","+admin.getPassword()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_ADMIN, content, false);
    }

    //Loading the clients based on the doc .txt
    public static ArrayList<Admin> loadAdmins() throws FileNotFoundException, IOException{

        ArrayList<Admin> admins = new ArrayList<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_ADMIN);
        String line = "";

        for (int i=0; i<content.size()-1;i++){
            Admin myAdmin = new Admin();
            line = content.get(i);

            myAdmin.setID(line.split(",")[0]);
            myAdmin.setName(line.split(",")[1]);
            myAdmin.setLastName(line.split(",")[2]);
            myAdmin.setEmail(line.split(",")[3]);
            myAdmin.setPassword(line.split(",")[4]);

            admins.add(myAdmin);
        }
        return admins;
    }

    //Saving members in the doc .txt
    public static void saveMembers(ArrayList<Member> memberList) throws IOException{
        String content = "";
        for(Member member: memberList){
            content += member.getID()+","+member.getName()+","+member.getLastName()+","+member.getEmail()+
                    ","+member.getPassword()+"\n";
        }
        UtilDoc.saveDoc(FILE_PATH_ADMIN, content, false);
    }

    //Loading the clients based on the doc .txt
    public static ArrayList<Member> loadMembers() throws FileNotFoundException, IOException{

        ArrayList<Member> members = new ArrayList<>();

        ArrayList<String> content = UtilDoc.readDoc(FILE_PATH_ADMIN);
        String line = "";

        for (int i=0; i<content.size()-1;i++){
            Member myMember = new Member();
            line = content.get(i);

            myMember.setID(line.split(",")[0]);
            myMember.setName(line.split(",")[1]);
            myMember.setLastName(line.split(",")[2]);
            myMember.setEmail(line.split(",")[3]);
            myMember.setPassword(line.split(",")[4]);

            members.add(myMember);
        }
        return members;
    }
}
