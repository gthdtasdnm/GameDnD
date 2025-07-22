package domain.character;

import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Die Klasse {@code PlayerCharacter} repräsentiert den spielbaren Hauptcharakter.
 *
 * <p>Sie erweitert {@link Character} um zusätzliche Spielfunktionen wie
 * Erfahrung, Skillpunkte und ein persönliches {@code QuestLog}.</p>
 *
 * <p>Bewegung, Erfahrungssammlung und Spielfortschritt werden hier zentral verwaltet.</p>
 *
 * <p>Geplant ist die Erweiterung um Levelsystem, Skillverteilung und Questmechanik.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class PlayerCharacter extends Character {
    private QuestLog questLog;

    //Attribute
    protected int experience;
    protected int skillpoints;

    public PlayerCharacter(String name, String guild, int maxHp,
                           int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super(name, guild, maxHp, strength, dexterity, inventory, equipment);
        experience = 0;
        skillpoints = 0;
        x = 0;
        y = 0;
    }

    public void addExperience(int amount){
        experience += amount;
        //TODO auf levelup überprüfen;
    }

    public void addSkillpoint(){
        skillpoints +=1;
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    // TODO: Weitere Spielerfunktionen wie Level, Erfahrung, Skills etc.
}
