package serializers;

import models.Deck;

public class DeckSerializer {

    String name;
    int id;

    public DeckSerializer(Deck deck) {
        this.name = deck.getName();
        this.id = deck.getId();
    }
}
