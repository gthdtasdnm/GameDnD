package domain.character;

import domain.inventory.Equipment;
import domain.inventory.Inventory;

public class Enemy extends Character{
    public Enemy(String name, String guild, int maxHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super(name, guild, maxHp, strength, dexterity, inventory, equipment);
    }
}
