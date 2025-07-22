package domain.quest;

import domain.item.Item;

import java.util.List;

public class Quest {
    private String id;
    private String name;
    private String description;
    private int experienceReward;
    private int goldReward;
    private List<Item> itemReward;

    public String getId() {return id;}

    //TODO:Methoden Getter Konstruktor
}
