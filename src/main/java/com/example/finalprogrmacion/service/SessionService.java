package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;

import java.util.List;

public interface SessionService {
    void createSession(Trainer trainer, List<Exercise> exercises, List<Member> members);
}
