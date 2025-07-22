package core.factory;

import domain.character.Character;
import domain.character.PlayerCharacter;
import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Fabrik zur Erstellung von Spieler-Charakteren.
 *
 * <p>Verwendung:</p>
 * <pre>{@code
 * CharacterFactory factory = new PlayerFactory();
 * Character player = factory.create("Nameless Hero", "Miliz", 120, 20, 15, null, null);
 * }</pre>
 */


public class PlayerFactory extends CharacterFactory{
    @Override
    public Character create(String name, String guild, int maxHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
        return new PlayerCharacter( name,  guild,  maxHp,  strength,  dexterity,  inventory, equipment);
    }
}
