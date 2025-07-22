package domain.item;

import domain.inventory.EquipmentSlot;

/**
 * Die Klasse {@code Armor} repräsentiert ein ausrüstbares Rüstungsteil im Spiel.
 *
 * <p>Sie erweitert {@link Item} und implementiert das {@link Equippable}-Interface,
 * wodurch sie einem {@link domain.character.Character} zugewiesen werden kann.</p>
 *
 * <p>Jede Rüstung besitzt eine definierte Verteidigungsstärke und ist einem konkreten
 * {@link domain.inventory.EquipmentSlot} zugeordnet.</p>
 *
 * <p>Der Angriffswert ist standardmäßig {@code 0}, da Rüstung keine Offensivfunktion hat.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Armor extends Item implements Equippable {
    private final int defense;
    private final EquipmentSlot slot;

    public Armor(String id, String name, String description, int price, int defense, EquipmentSlot slot) {
        super(id, name, description, price);
        this.defense = defense;
        this.slot = slot;
    }

    @Override
    public void equip(Character character) {}

    public int getDefense() {return defense;}

    @Override
    public int getAttack() {return 0;}

    @Override


    public EquipmentSlot getSlot() {return slot;}

}
