package domain.character;

import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Die Klasse {@code NPC} repräsentiert einen nicht spielbaren Charakter im Spiel.
 *
 * <p>Ein {@code NPC} basiert auf {@link Character} und dient zur Weltbelebung,
 * Informationsvermittlung oder potenziell als Questgeber.</p>
 *
 * <p>Geplant ist die Integration eines {@code QuestLog}, sodass NPCs Quests zuweisen können.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class NPC extends Character{
    //Quest die der NPC dir gibt
    //protected QuestLog questlog;

    public NPC(String name,  String guild, int maxHp,
               int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super( name, guild,  maxHp,
         strength,  dexterity,  inventory,  equipment);
    }
}
