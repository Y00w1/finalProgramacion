package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.SceneController;
import com.example.finalprogrmacion.service.*;

public class GymServiceImpl {
    private final MemberService memberService;
    private final ExerciseService exerciseService;
    private final SceneService sceneService;
    private final LoginService loginService;
    private final TrainerService trainerService;
    private final SessionService sessionService;


    public GymServiceImpl(){
        this.memberService = new MemberServiceImpl();
        this.exerciseService = new ExerciseServiceImpl();
        this.sceneService = new SceneController();
        this.loginService = new LoginServiceImpl();
        this.trainerService = new TrainerServiceImpl();
        this.sessionService = new SessionServiceImpl();
    }

    public MemberService getMemberService(){
        return memberService;
    }
    public ExerciseService getExerciseService(){
        return exerciseService;
    }
    public SceneService getSceneService() {
        return sceneService;
    }
    public LoginService getLoginService() {return loginService;}
    public TrainerService getTrainerService() {
        return trainerService;
    }
    public SessionService getSessionService() {
        return sessionService;
    }
}
