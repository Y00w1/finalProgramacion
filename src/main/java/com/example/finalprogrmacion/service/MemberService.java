package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.MemberDTO;

import java.util.List;
import java.util.stream.Stream;

public interface MemberService {
    void addMember(String ID, String name, String lastName, String email, String password, Double weight, Double height, Integer months);
    void deleteMember(String ID);
    List<MemberDTO> generateListDTO();
    Stream<Member> searchByName(String name);
    void sortByFidelity();
    void browseHashMap();
}
