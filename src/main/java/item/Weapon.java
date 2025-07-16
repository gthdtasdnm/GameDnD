package item;

import models.EquipmentSlot;

public class Weapon extends Item implements Equippable {
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
