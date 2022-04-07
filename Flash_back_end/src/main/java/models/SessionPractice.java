package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import Factories.DAOfactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import DBdao.DeckDAO;
import DBdao.HibernateUtils;

@Entity
@Table(name = "SessionPractice")
public class SessionPractice implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String date;

    @ManyToOne
    private Account account;

    @Column
    private double Scoresum;

    @OneToMany(fetch = FetchType.EAGER)
    private  List<SessionCard> sessionCards;

    public SessionPractice() {

    }

    public SessionPractice(Account account) {
        this.account = account;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.date = dateFormat.format(date);
    }

    public static SessionPractice getByID(int id) {
        return (SessionPractice) DAOfactory.getSessionDao().findById(id);
    }

    public void save() {
        DAOfactory.getSessionDao().saveOrUpdate(this);
    }


    public double getScoresum() {
        return Scoresum;
    }

    public void setScoresum(double scoresum) {
        Scoresum = scoresum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public List<SessionCard> getSessionCards() {
        return sessionCards;
    }

    public void setSessionCards(List<SessionCard> sessionCards) {
        this.sessionCards = sessionCards;
    }
}
// datum opslaan + goefende kaarten gemiddelde score
