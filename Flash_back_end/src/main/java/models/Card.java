package models;

import Factories.DAOfactory;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card implements Serializable {

	public Card() {

	}

	public Card(String name, String description){
		this.name = name;
		this.description = description;
		this.setPathToImage("");
	}

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String description;

	@Column
	private String pathToImage;

	@Column
	private boolean score;

	@ManyToOne(fetch = FetchType.EAGER)
	private Deck deck;

	@ManyToMany(mappedBy = "cards", fetch = FetchType.EAGER)
	private Set<Tag> tags = new HashSet<Tag>();




	public static Card getById(int id){
		return (Card) DAOfactory.getCardDAO().findById(id);
	}

	public void save(){
		DAOfactory.getCardDAO().saveOrUpdate(this);
	}

	public void delete(){
		DAOfactory.getCardDAO().delete(this);
	}
	// getters en setters
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public boolean hasImage(){
		if (this.getPathToImage() == null){
			return false;
		}
		return true;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPathToImage() {
		return pathToImage;
	}

	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public boolean isScore() {
		return score;
	}

	public void setScore(boolean score) {
		this.score = score;
	}
}
