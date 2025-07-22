package core.factory;

import domain.character.Character;
import domain.character.NPC;
import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Fabrik zur Erstellung von NPCs (Nicht-Spieler-Charakteren).
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * CharacterFactory factory = new NpcFactory();
 * Character npc = factory.create("Diego", "Schatten", 80, 10, 12, null, null);
 * }</pre>
 */

public class NpcFactory extends CharacterFactory{
    @Override
    public Character create(String name, String guild, int maxHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
        return new NPC( name,  guild,  maxHp, strength,  dexterity,  inventory,  equipment);
    }
}
