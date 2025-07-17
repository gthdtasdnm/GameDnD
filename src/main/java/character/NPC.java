package character;

import models.Equipment;
import models.Inventory;

import java.util.Set;

public class NPC extends Character{
    //Quest die der NPC dir gibt
    //protected QuestLog questlog;

    public NPC(String name,  String guild, int maxHp, int currentHp,
               int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super( name, guild,  maxHp,  currentHp,
         strength,  dexterity,  inventory,  equipment);
    }
}
