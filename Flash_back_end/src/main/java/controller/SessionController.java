package controller;

import Utils.TemporarySession;
import com.google.protobuf.SingleFieldBuilderV3;
import com.opensymphony.xwork2.ActionSupport;
import models.*;
import serializers.JSONSerializer;

import javax.naming.ldap.HasControls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SessionController extends ActionSupport {

    int id;

    private int DeckID;
    private int TagID;
    private int CardID;
    private int CardSize;
    private int AccountID;
    private boolean cardRate;

    private JSONSerializer serializer = new JSONSerializer();
    private String responseJson;

    public String startSessionByTag() {
        Account account = Account.getById(AccountID);
        Tag tag = Tag.getById(TagID);
        List<Card> cards = (List<Card>) tag.getCards();
        SessionPractice sessionPractice = new SessionPractice(account);

        HashMap<Integer, Card> falseCards = getFalseCards(cards);

        TemporarySession tempSession = new TemporarySession(sessionPractice, falseCards);
        TemporarySession.setTemporarySession(account.getId(), tempSession);

        responseJson = serializer.serializeCardsForPractice(falseCards);

        return SUCCESS;
    }

    public String startSessionByDeck() {
        Account account = Account.getById(AccountID);
        Deck deck = Deck.getById(DeckID);
        List<Card> cards = deck.getCards();
        SessionPractice sessionPractice = new SessionPractice(account);

        HashMap<Integer, Card> falseCards = getFalseCards(cards);
        TemporarySession tempSession = new TemporarySession(sessionPractice, falseCards);

        TemporarySession.setTemporarySession(account.getId(), tempSession);

        responseJson = serializer.serializeCardsForPractice(falseCards);

        return SUCCESS;
    }


    public String rateCard(){
        Account account = Account.getById(AccountID);

        TemporarySession tempSession = TemporarySession.TemporarySessionMap.get(account.getId());
        Card toRate = tempSession.getCurrentCards().get(CardID);
        toRate.setScore(cardRate);

        System.out.println(toRate.isScore());

        return SUCCESS;
    }


    public String getLatestSession(){
        Account account = Account.getById(AccountID);

        TemporarySession tempSession = TemporarySession.TemporarySessionMap.get(account.getId());
        HashMap<Integer, Card> cardsToSave = tempSession.getCurrentCards();

        responseJson = serializer.serializeCardsForPractice(cardsToSave);

        return SUCCESS;
    }

    public String repeatSession(){
        Account account = Account.getById(AccountID);

        TemporarySession tempSession = TemporarySession.TemporarySessionMap.get(account.getId());
        SessionPractice sessionToSave = tempSession.getSession();
        List<Card> allCards = (List<Card>) tempSession.getCurrentCards().values();
        HashMap<Integer, Card> falseCards = getFalseCards(allCards);
        tempSession.setCurrentCards(falseCards);

        responseJson = serializer.serializeCardsForPractice(falseCards);

        return SUCCESS;
    }



    private HashMap<Integer, Card> getFalseCards(List<Card> cards) {
        HashMap<Integer, Card> falseCards = new HashMap<>();

        for (Card card : cards) {
            //alleen foute scores
            if (!card.isScore()) {
                falseCards.put(card.getId(), card);
            }
        }

        return falseCards;
    }

    public boolean isCardRate() {
        return cardRate;
    }

    public void setCardRate(boolean cardRate) {
        this.cardRate = cardRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeckID() {
        return DeckID;
    }

    public void setDeckID(int deckID) {
        DeckID = deckID;
    }

    public int getTagID() {
        return TagID;
    }

    public void setTagID(int tagID) {
        TagID = tagID;
    }

    public int getCardID() {
        return CardID;
    }

    public void setCardID(int cardID) {
        CardID = cardID;
    }

    public int getCardSize() {
        return CardSize;
    }

    public void setCardSize(int cardSize) {
        CardSize = cardSize;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }
}
