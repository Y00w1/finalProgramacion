package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.service.SessionService;

import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService {
    List<Session> sessions= new ArrayList<Session>();

    @Override
    public void createSession(Trainer trainer, List<Exercise> exercises, List<Member> members) {
        sessions.add(new Session(trainer, exercises, members));
    }
}
