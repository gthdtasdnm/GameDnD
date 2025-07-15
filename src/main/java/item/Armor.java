package item;

import models.EquipmentSlot;

public class Armor extends Item implements Equipable{
    private final int defense;
    private final EquipmentSlot slot;

    protected Armor(String id, String name, String description, int price, int defense, EquipmentSlot slot) {
        super(id, name, description, price);
        this.defense = defense;
        this.slot = slot;
    }

    @Override
    public void equip(Character character) {}

    public int getDefense() {return defense;}

    public EquipmentSlot getSlot() {return slot;}

}
