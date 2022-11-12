package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.MemberDTO;
import com.example.finalprogrmacion.model.User;
import com.example.finalprogrmacion.service.MemberService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberServiceImpl implements MemberService {
    List<Member> membersArList = new ArrayList<>();
    HashMap<String, Member> membersHashMap = new HashMap<>();

    public void addMember(String ID, String name, String lastName, String email, String password, Double weight, Double height, Integer months){
        membersHashMap.put(ID, new Member(ID, name, lastName, email, password, weight, height, months));
    }

    public void deleteMember(String ID){
        membersHashMap.remove(ID);
    }

    public List<MemberDTO> generateListDTO(){
        return membersArList.stream()
                .map(m -> new MemberDTO(m.getName(), m.getWeight(), m.getHeight(), m.getMonths() ))
                .collect(Collectors.toList());
    }

    public Stream<Member> searchByName(String name){
        return membersArList.stream().filter(m->name.equalsIgnoreCase(m.getName())).limit(1);
    }

    public void sortByFidelity(){
        membersArList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                Integer month1 = o1.getMonths();
                Integer month2 = o2.getMonths();
                return month1.compareTo(month2);
            }
        });
    }
    public void browseHashMap(){
        for (String m : membersHashMap.keySet()){
            System.out.println("llave= "+m+"nombre= "+membersHashMap.get(m).getName());
        }
    }
}
