package character;

import models.Equipment;
import models.Inventory;

public class Enemy extends Character{
    public Enemy(String name, String guild, int maxHp, int currentHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super(name, guild, maxHp, currentHp, strength, dexterity, inventory, equipment);
    }
}
