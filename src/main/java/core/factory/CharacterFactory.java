package core.factory;

import domain.character.Character;
import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Abstrakte Fabrikklasse zur Erstellung von Charakteren.
 *
 * Subklassen implementieren die {@code create}-Methode, um konkrete Charaktere zu erzeugen.
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * CharacterFactory factory = new NpcFactory();
 * Character npc = factory.create("Diego", "Söldner", 100, 15, 10, null, null);
 * }</pre>
 */

public abstract class CharacterFactory {
    public abstract Character create(String name, String guild, int maxHp,
                               int strength, int dexterity, Inventory inventory, Equipment equipment);
}
