package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.SceneController;
import com.example.finalprogrmacion.service.ExerciseService;
import com.example.finalprogrmacion.service.MemberService;
import com.example.finalprogrmacion.service.SceneService;

public class GymServiceImpl {
    private final MemberService memberService;
    private final ExerciseService exerciseService;
    private final SceneService sceneService;


    public GymServiceImpl(){
        this.memberService = new MemberServiceImpl();
        this.exerciseService = new ExerciseServiceImpl();
        this.sceneService = new SceneController();
    }

    public MemberService getMemberService(){
        return memberService;
    }
    public ExerciseService exerciseService(){
        return exerciseService;
    }
    public SceneService getSceneService() {
        return sceneService;
    }
}
