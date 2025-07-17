package Dialog;

public class ReceiveItem implements InfoElement {
    private String itemName;

    public ReceiveItem(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        System.out.println("Item erhalten: " + itemName);
        // Dein Inventory-Manager wäre hier zuständig
    }
}

