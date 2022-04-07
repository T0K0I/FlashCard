package serializers;

import models.Tag;

public class TagSerializer {
    String name;
    int id;

    public TagSerializer(Tag tag){
        this.name = tag.getName();
        this.id = tag.getId();
    }
}
