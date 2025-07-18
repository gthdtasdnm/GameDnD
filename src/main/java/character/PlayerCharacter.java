package character;

import models.Equipment;
import models.Inventory;
import models.Quest;

import java.util.List;
import java.util.Set;

public class PlayerCharacter extends Character {
    private QuestLog questLog;

    //Attribute
    protected int experience;
    protected int skillpoints;

    public PlayerCharacter(String name, String guild, int maxHp, int currentHp,
                           int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super(name, guild, maxHp, currentHp, strength, dexterity, inventory, equipment);
        experience = 0;
        skillpoints = 0;
    }

    public PlayerCharacter() {
        super();
    }

    public void addExperience(int amount){
        experience += amount;
        //TODO auf levelup überprüfen;
    }

    public void addSkillpoint(){
        skillpoints +=1;
    }

    // TODO: Weitere Spielerfunktionen wie Level, Erfahrung, Skills etc.
}
