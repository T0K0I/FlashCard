package models;

import Factories.DAOfactory;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", updatable = true, nullable = false)
    private String name;

    @Column(name = "email", updatable = true, nullable = false, unique = true)
    private String email;

    @Column(name = "password", updatable = true, nullable = false)
    private String password;

    @Column(name = "isDocent", updatable = true, nullable = false)
    private Boolean isDocent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
    private List<SessionPractice> sessionPractices;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
    private List<Deck> decks;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "account")
    private List<Tag> tags;


    //database gebruik

    public static Account getById(int ID){
        return (Account) DAOfactory.getAccountDAO().findById(ID);
    }

    public static Account getByEmail(String email){
        return (Account) DAOfactory.getAccountDAO().findByEmail(email);
    }

    public static boolean isEmailValid(String email){
        if (email.contains("scalda.nl")){return true;}
        return false;
    }

    public boolean isEmailForDocent(String email){
        if (email.contains("@student.scalda.nl")){
            return false;
        }
        return true;
    }

    public void save(){
        DAOfactory.getAccountDAO().saveOrUpdate(this);
    }

    // getters en setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public Boolean getDocent() {return isDocent;}

    public void setDocent(Boolean docent) {isDocent = docent;}

    public List<Tag> getTags() {
        return tags;
    }

    public List<SessionPractice> getSessionPractices() {
        return sessionPractices;
    }
    public void setSessionPractices(List<SessionPractice> sessionPractices) {
        this.sessionPractices = sessionPractices;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
