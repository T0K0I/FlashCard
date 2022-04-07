package serializers;

import Factories.DAOfactory;
import com.google.gson.Gson;
import models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JSONSerializer {

    Gson gson = new Gson();

    //straks kijken hoe dit met generics kan
    public String serializeAccounts(Account[] collectionInput) {
        ArrayList<AccountSerializer> arrayList = new ArrayList<>();
        for (Account i : collectionInput) {
            AccountSerializer serializer = new AccountSerializer(i);
            arrayList.add(serializer);
        }
        return gson.toJson(arrayList);
    }

    public String serializeDecks(Deck[] collectionInput) {
        ArrayList<DeckSerializer> arrayList = new ArrayList<>();
        for (Deck i : collectionInput) {
            DeckSerializer serializer = new DeckSerializer(i);
            arrayList.add(serializer);
        }
        return gson.toJson(arrayList);
    }

    public String serializeCards(Card[] collectionInput) {
        ArrayList<CardSerializer> arrayList = new ArrayList<>();
        for (Card i : collectionInput) {
            CardSerializer serializer = new CardSerializer(i);
            arrayList.add(serializer);
        }
        return gson.toJson(arrayList);
    }

    public String serializeTags(List<Tag> collectionInput) {
        ArrayList<TagSerializer> arrayList = new ArrayList<>();
        for (Tag i : collectionInput) {
            TagSerializer serializer = new TagSerializer(i);
            arrayList.add(serializer);
        }
        return gson.toJson(arrayList);
    }

    public String SerializeAccountWithPassword(Account account){
        AccountSerializer serializer = new AccountSerializer(account, account.getPassword());
        return gson.toJson(serializer);
    }

    public String serializeCardsForPractice(HashMap<Integer, Card> cardMap){
        ArrayList<CardSerializer> arrayList = new ArrayList<>();

        for (Card card:cardMap.values()) {
            CardSerializer serializer = new CardSerializer(card);
            arrayList.add(serializer);
        }

        return gson.toJson(arrayList);
    }

    public String serializeDeck(Deck deck){
        DeckSerializer serializer = new DeckSerializer(deck);
        return gson.toJson(serializer);
    }

    public String serializeCard(Card card){
        CardSerializer serializer = new CardSerializer(card);
        return gson.toJson(serializer);
    }

    public String serializeTag(Tag tag){
        TagSerializer serializer = new TagSerializer(tag);
        return gson.toJson(serializer);
    }


}
