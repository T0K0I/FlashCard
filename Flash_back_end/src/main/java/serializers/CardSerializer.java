package serializers;

import models.Card;

public class CardSerializer {

    String name;
    String description;
    String img;
    int id;
    boolean score;

    public CardSerializer(Card card) {
        this.name = card.getName();
        this.description = card.getDescription();
        this.img = card.getPathToImage();
        this.id = card.getId();
        this.score = card.isScore();
    }
}
