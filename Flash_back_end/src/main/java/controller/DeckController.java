package controller;

import com.opensymphony.xwork2.ActionSupport;
import models.Account;
import models.Card;
import models.Deck;
import serializers.JSONSerializer;

import java.util.ArrayList;
import java.util.List;

public class DeckController extends ActionSupport {

    private String name;
    private int id;
    private int accountID;

    private JSONSerializer serializer = new JSONSerializer();
    private String responseJson;

    public String createDeck(){
        Account account = Account.getById(accountID);
        Deck deck = new Deck(name);
        deck.setAccount(account);
        deck.save();
        return SUCCESS;
    }

    public String getDecks() {
        System.out.println(accountID);
        Account account = Account.getById(accountID);
        List<Deck> decks = account.getDecks();
        responseJson = serializer.serializeDecks(decks.toArray(new Deck[decks.size()]));
        return SUCCESS;
    }

    public String getCardsOfDeck(){
        Deck deck = Deck.getById(id);
        List<Card> cards = deck.getCards();
        responseJson = serializer.serializeCards(cards.toArray(new Card[cards.size()]));
        return SUCCESS;
    }

    public String deleteDeck(){
        Deck deck = Deck.getById(id);
        deck.delete();
        responseJson = serializer.serializeDeck(deck);
        return SUCCESS;
    }

    public String updateDeck(){
        Deck deck = Deck.getById(id);
        deck.setName(name);
        deck.save();
        responseJson = serializer.serializeDeck(deck);
        return SUCCESS;
    }


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

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

}
