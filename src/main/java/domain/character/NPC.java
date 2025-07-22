package domain.character;

import domain.inventory.Equipment;
import domain.inventory.Inventory;

public class NPC extends Character{
    //Quest die der NPC dir gibt
    //protected QuestLog questlog;

    public NPC(String name,  String guild, int maxHp,
               int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super( name, guild,  maxHp,
         strength,  dexterity,  inventory,  equipment);
    }
}
