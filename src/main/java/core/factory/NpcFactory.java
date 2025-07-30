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
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NpcFactory.class);
    @Override
    public Character create(String name, String guild, int maxHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
    logger.info("create()");        return new NPC( name,  guild,  maxHp, strength,  dexterity,  inventory,  equipment);
    }
}
