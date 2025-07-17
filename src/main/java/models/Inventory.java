package models;

import item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {
    protected int gold;
    protected Map<String, Item> inventory;

    public Inventory(){
        gold = 0;
        inventory = new HashMap<>();
    }

    public void addGold(int amount){
        gold += amount;
    }

    public void removeGold(int amount){
        if(gold - amount <= 0){
            System.out.println("nicht genug Gold");
        }else{
            gold -= amount;
        }
    }

    public void addItem(Item item){
        inventory.put(item.getId(),item);
    }

    public boolean hasItem(Item item){
        return inventory.containsKey(item.getId());
    }

    public void removeItem(Item item){
        inventory.remove(item.getId());
    }

    @Override
    public String toString() {
        return inventory.values().stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(", "));
    }





}
