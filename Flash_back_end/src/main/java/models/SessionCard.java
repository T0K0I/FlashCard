package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;


import Factories.DAOfactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import DBdao.DeckDAO;
import DBdao.HibernateUtils;


@Entity
@Table(name = "Sessioncard")
public class SessionCard implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private SessionPractice sessionPractice;

    @OneToOne
    private Card card;

    @Column
    private boolean correct;

    public void save(){
        DAOfactory.getSessionCardDao().saveOrUpdate(this);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SessionPractice getSessionPractice() {
        return sessionPractice;
    }

    public void setSessionPractice(SessionPractice sessionPractice) {
        this.sessionPractice = sessionPractice;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}