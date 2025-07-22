package domain.character;

import domain.inventory.Equipment;
import domain.inventory.Inventory;

/**
 * Die Klasse {@code Enemy} repräsentiert einen feindlichen Charakter im Spiel.
 *
 * <p>Ein {@code Enemy} ist eine konkrete Unterklasse von {@link Character} und wird
 * hauptsächlich im Kampf verwendet.</p>
 *
 * <p>Feinde besitzen dieselben Attribute wie Spieler oder NPCs, agieren jedoch
 * gegnerisch und können im {@code FightState} bekämpft werden.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Enemy extends Character{
    public Enemy(String name, String guild, int maxHp, int strength, int dexterity, Inventory inventory, Equipment equipment) {
        super(name, guild, maxHp, strength, dexterity, inventory, equipment);
    }
}
