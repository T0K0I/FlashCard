package controller;

import Factories.DAOfactory;
import com.opensymphony.xwork2.ActionSupport;
import models.Account;
import models.Card;
import models.Tag;
import serializers.JSONSerializer;

import java.util.List;
import java.util.Set;

public class TagController extends ActionSupport {

    private String name;
    private int id;
    private int cardID;
    private int accountID;

    private String searchString;
    private JSONSerializer serializer = new JSONSerializer();
    private String responseJson;

    public String createTag(){
        Account account = Account.getById(accountID);
        Tag tag = new Tag(name);
        tag.setAccount(account);
        tag.save();

        responseJson = serializer.serializeTag(tag);

        return SUCCESS;
    }

    public String deleteTag(){
        Tag tag = Tag.getById(id);
        tag.delete();

        responseJson = serializer.serializeTag(tag);


        return SUCCESS;
    }

    public String getCardsOfAccount(){
        Account account = Account.getById(accountID);
        responseJson = serializer.serializeTags(account.getTags());

        return SUCCESS;
    }

    public String getTagsOfCard(){
        Card card = Card.getById(cardID);
        responseJson = serializer.serializeTags((List<Tag>) card.getTags());

        return SUCCESS;
    }

    public String attachTagToCard(){
        Card card = Card.getById(cardID);
        Tag tag = Tag.getById(id);

        tag.getCards().add(card);
        tag.save();

        responseJson = serializer.serializeTag(tag);

        return SUCCESS;
    }

    public String detachTagFromCard(){
        Card card = Card.getById(cardID);
        Tag tag = Tag.getById(id);

        Set<Tag> tagsOfCard = card.getTags();
        tagsOfCard.remove(tag);

        card.setTags(tagsOfCard);

        card.save();


        responseJson = serializer.serializeTag(tag);

        return SUCCESS;
    }

    public String updateTag(){
        Tag tag = Tag.getById(id);
        tag.setName(name);
        tag.save();

        responseJson = serializer.serializeTag(tag);

        return SUCCESS;
    }


    public String searchByName(){
        System.out.println(accountID);
        System.out.println(searchString);

        List<Tag> tags = DAOfactory.getTagDao().searchByName(accountID, searchString);


        for (Tag tag:
             tags) {
            System.out.println(tag.getName());

        }


        responseJson = serializer.serializeTags(tags);

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

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
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

    public String getSearchString() {return searchString;}

    public void setSearchString(String searchString) {this.searchString = searchString;}
}
