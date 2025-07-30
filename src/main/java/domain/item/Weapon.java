package domain.item;

import domain.inventory.EquipmentSlot;

/**
 * Die Klasse {@code Weapon} repräsentiert eine ausrüstbare Waffe im Spiel.
 *
 * <p>Sie erweitert {@link Item} und implementiert das {@link Equippable}-Interface,
 * wodurch sie einem {@link domain.character.Character} im Slot {@link domain.inventory.EquipmentSlot#WEAPON} zugewiesen werden kann.</p>
 *
 * <p>Waffen besitzen einen Angriffs-Wert ({@code attack}), aber keinen Verteidigungswert.</p>
 *
 * <p>Typisch für Charaktere, die im Nah- oder Fernkampf Schaden verursachen sollen.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Weapon extends Item implements Equippable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Weapon.class);
    private final int attack;

    public Weapon(String id, String name, String description, int price, int attack){
        super(id,name,description,price);
        this.attack = attack;
    }

    @Override
    public void equip(Character character) {}

    @Override
    public EquipmentSlot getSlot() {return EquipmentSlot.WEAPON;}

    @Override
    public int getDefense() {return 0;}

    public int getAttack(){return attack;}

}
