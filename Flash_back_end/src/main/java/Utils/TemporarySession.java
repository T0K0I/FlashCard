package Utils;

import models.Card;
import models.SessionPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class TemporarySession {
    SessionPractice session;
    HashMap<Integer, Card> currentCards;

    public static HashMap<Integer, TemporarySession> TemporarySessionMap = new HashMap<Integer, TemporarySession>();

    public TemporarySession(SessionPractice session, HashMap<Integer, Card> currentCards) {
        this.session = session;
        this.currentCards = currentCards;
    }


    public static void setTemporarySession(int id, TemporarySession temp) {
        if (TemporarySession.TemporarySessionMap.containsKey(id)) {
            TemporarySession.TemporarySessionMap.remove(id);
        }

        TemporarySession.TemporarySessionMap.put(id, temp);
    }


    public SessionPractice getSession() {
        return session;
    }

    public void setSession(SessionPractice session) {
        this.session = session;
    }

    public HashMap<Integer, Card> getCurrentCards() {
        return currentCards;
    }

    public void setCurrentCards(HashMap<Integer, Card> currentCards) {
        this.currentCards = currentCards;
    }
}
