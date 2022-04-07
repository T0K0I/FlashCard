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
@Table(name = "deck")
public class Deck implements Serializable {

	public Deck() {

	}

	public Deck(String name){
		this.name = name;
	}

	@Id
	@GeneratedValue
	private int id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "deck", cascade = CascadeType.ALL)
	private List<Card> cards;

	@ManyToOne(fetch = FetchType.EAGER)
	private Account account;

	@Column
	private String name;



	public void save(){
		DAOfactory.getDeckDAO().saveOrUpdate(this);
	}

	public void delete(){
		DAOfactory.getDeckDAO().delete(this);
	}

	public static Deck getById(int ID){
		return (Deck) DAOfactory.getDeckDAO().findById(ID);
	}

	// getters en setters
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
