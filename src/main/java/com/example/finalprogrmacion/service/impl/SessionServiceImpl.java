package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.service.SessionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService {


    @Override
    public void createSession(String name, Trainer trainer, List<Exercise> exercises, List<Member> members, LocalDate day, LocalTime time) {
        //sessions.add(new Session(name, trainer, exercises, members, day, time));
    }
}
