package item;

import models.EquipmentSlot;

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

    public EquipmentSlot getSlot() {return slot;}

}
