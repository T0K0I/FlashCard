package models;

import Factories.DAOfactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag implements Serializable {

	public Tag(String name){
		this.name = name;
	}

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "tag_card",
			joinColumns = { @JoinColumn(name = "fk_tag") },
			inverseJoinColumns = { @JoinColumn(name = "fk_card") })
	private Set<Card> cards = new HashSet<Card>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Account account;

	public Tag() {

	}

	public static Tag getById(int id){
		return (Tag) DAOfactory.getTagDao().findById(id);
	}

	public void save(){
		DAOfactory.getTagDao().saveOrUpdate(this);
	}

	public void delete(){
		DAOfactory.getTagDao().delete(this);
	}

	// getters en setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {return account;}

	public void setAccount(Account account) {this.account = account;}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

//	public Set<Card> getCards() {
//		return cards;
//	}
//
//	public void setCards(Set<Card> cards) {
//		this.cards = cards;
//	}
}
