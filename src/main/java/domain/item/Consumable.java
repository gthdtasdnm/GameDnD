package domain.item;

import domain.inventory.PotionEffect;

public class Consumable extends Item implements Usable{
    private PotionEffect effect;
    private int magnitude;

    public Consumable(String id, String name, String description, int price, PotionEffect effect, int magnitude){
        super(id,name,description,price);
        this.effect = effect;
        this.magnitude = magnitude;
    }

    public void use(Character character){}

    public PotionEffect getEffect(){return effect;}

    public int getMagnitude(){return magnitude;}
}
