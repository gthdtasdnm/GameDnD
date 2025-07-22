package domain.item;

import domain.inventory.PotionEffect;

/**
 * Die Klasse {@code Consumable} repräsentiert einen verbrauchbaren Gegenstand wie z. B. einen Trank.
 *
 * <p>Sie erweitert {@link Item} und implementiert das {@link Usable}-Interface,
 * wodurch sie im Spiel auf einen {@link domain.character.Character} angewendet werden kann.</p>
 *
 * <p>Ein Consumable besitzt einen {@link domain.inventory.PotionEffect} und eine Wirkstärke ({@code magnitude}),
 * die z. B. festlegt, wie viele Lebenspunkte geheilt werden.</p>
 *
 * <p>Typisches Beispiel: Heiltrank mit Effekt {@code HEAL} und Stärke {@code 25}.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


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
