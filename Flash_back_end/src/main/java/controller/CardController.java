package controller;

import com.opensymphony.xwork2.ActionSupport;
import models.Card;
import models.Deck;
import serializers.JSONSerializer;

public class CardController extends ActionSupport {

    private int id;
    private int deckID;
    private String name;
    private String description;
    private JSONSerializer serializer = new JSONSerializer();
    private String responseJson;

    public String createCard() {
        Deck deck = Deck.getById(deckID);
        Card card = new Card(name, description);
        card.setDeck(deck);
        card.save();
        responseJson = serializer.serializeCard(card);
        return SUCCESS;
    }

    public String deleteCard() {
        Card card = Card.getById(id);
        card.delete();
        responseJson = serializer.serializeCard(card);
        return SUCCESS;
    }

    public String updateCard() {
        Card card = Card.getById(id);
        card.setName(name);
        card.setDescription(description);
        card.save();
        responseJson = serializer.serializeCard(card);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeckID() {
        return deckID;
    }

    public void setDeckID(int deckID) {
        this.deckID = deckID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }
}
