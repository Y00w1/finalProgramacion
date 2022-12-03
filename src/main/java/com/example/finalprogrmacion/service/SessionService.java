package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SessionService {
    void createSession(String name, Trainer trainer, List<Exercise> exercises, List<Member> members, LocalDate day, LocalTime time);
}
