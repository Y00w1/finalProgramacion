package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.MemberDTO;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface MemberService {
    void loadMembers();
    ObservableList<Member> fillObLiMembers();
    void addMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException;
    void deleteMember(String ID) throws IOException;
    List<MemberDTO> generateListDTO();
    Stream<Member> searchByName(String name);
    void sortByFidelity();
    void browseHashMap();
    void editMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age)throws IOException, InputException;
    void sortByName(FilteredList<Member> filteredlist, TextField textField);

}
