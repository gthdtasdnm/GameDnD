package character;

import models.Quest;

import java.util.List;

public class PlayerCharacter extends Character {
    private QuestLog questLog;

    //Attribute
    protected int experience;
    protected int skillpoints;

    public PlayerCharacter(String name, CharacterState state) {
        super(name, state);
        experience = 0;
        skillpoints = 0;
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
