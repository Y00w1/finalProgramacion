package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.MemberDTO;
import com.example.finalprogrmacion.resources.Persistence;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.InputsVal;
import com.example.finalprogrmacion.service.MemberService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberServiceImpl implements MemberService {
    private final InputsVal inpVal = new InputsVal();//Class to make validations
    List<Member> membersArList = new ArrayList<>();
    HashMap<String, Member> membersHashMap = new HashMap<>();

    //Load the members from persistence
    @Override
    public void loadMembers() {
        try{
            membersHashMap = Persistence.loadMembers();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
//Fill observable list for the controller
    @Override
    public ObservableList<Member> fillObLiMembers() {
        ObservableList<Member> membersObList = FXCollections.observableArrayList();
        membersObList.addAll(membersHashMap.values());
        return membersObList;
    }
    public void addMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException {
        inpVal.emailInput(email);
        inpVal.doubleInput(weight);
        inpVal.doubleInput(height);
        inpVal.intInput(age);

        membersHashMap.put(ID, new Member(ID, name, lastName, email, password,Double.parseDouble(weight) , Double.parseDouble(height), Integer.parseInt(age)));
        Persistence.saveMembers(membersHashMap);
    }

    public void deleteMember(String ID) throws IOException {
        membersHashMap.remove(ID);
        Persistence.saveMembers(membersHashMap);
    }

    public List<MemberDTO> generateListDTO(){
        return membersArList.stream()
                .map(m -> new MemberDTO(m.getID(), m.getName(), m.getWeight(), m.getHeight(), m.getAge() ))
                .collect(Collectors.toList());
    }

    public Stream<Member> searchByName(String name){
        return membersArList.stream().filter(m->name.equalsIgnoreCase(m.getName())).limit(1);
    }

    public void sortByFidelity(){
        membersArList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                Integer month1 = o1.getAge();
                Integer month2 = o2.getAge();
                return month1.compareTo(month2);
            }
        });
    }
    public void browseHashMap(){
        for (String m : membersHashMap.keySet()){
            System.out.println("llave= "+m+"nombre= "+membersHashMap.get(m).getName());
        }
    }
//Edit
    @Override
    public void editMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException {
        inpVal.emailInput(email);
        inpVal.doubleInput(weight);
        inpVal.doubleInput(height);
        inpVal.intInput(age);
        membersHashMap.replace(ID, new Member(ID, name, lastName, email, password, Double.parseDouble(weight), Double.parseDouble(height), Integer.parseInt(age)) );
        Persistence.saveMembers(membersHashMap);
    }

    //Sort
    @Override
    public void sortByName(FilteredList<Member> filteredList, TextField textField){
        textField.textProperty().addListener((prop, old, text)->{
            filteredList.setPredicate(element ->{
                if (text == null || text.isEmpty()) return true;
                String name = element.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
    }


}
