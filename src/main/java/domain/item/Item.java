package domain.item;

public abstract class Item {
    protected final String id;
    protected final String name;
    protected final String description;
    protected final int price;

    protected Item(String id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {return name;}

    public int getPrice() {return price;}

    public String getDescription() {return description;}

    public String getId() {return id;}

}
