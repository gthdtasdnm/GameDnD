package item;

import models.EquipmentSlot;

public class Weapon extends Item implements Equipable{
    private final int attack;

    protected Weapon(String id, String name, String description, int price, int attack){
        super(id,name,description,price);
        this.attack = attack;
    }

    @Override
    public void equip(Character character) {}

    public int getAttack(){return attack;}

}
