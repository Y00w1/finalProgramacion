package com.example.finalprogrmacion.model;

import java.util.HashMap;

public class SessionPer {
    //Class to save the list of sessions in the .xml
    private HashMap<Integer, Session> sessions;

    public SessionPer() {
    }

    public SessionPer(HashMap<Integer, Session> sessions) {
        this.sessions = sessions;
    }

    public HashMap<Integer, Session> getSessions() {
        return sessions;
    }

    public void setSessions(HashMap<Integer, Session> sessions) {
        this.sessions = sessions;
    }
}
