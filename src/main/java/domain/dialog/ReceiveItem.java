package domain.dialog;

/**
 * Die Klasse {@code ReceiveItem} ist ein {@link InfoElement}, das dem Spieler
 * beim Ausführen ein Item übergibt.
 *
 * <p>Aktuell wird der Itemname als Textausgabe angezeigt. In einer späteren Version
 * sollte hier der {@code Inventory}-Manager aufgerufen werden, um das Item
 * tatsächlich ins Inventar zu legen.</p>
 *
 * <p>Typische Verwendung in {@link Information}, um Belohnungen innerhalb von Dialogen zu geben.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ReceiveItem implements InfoElement {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ReceiveItem.class);
    private String itemName;

    public ReceiveItem(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getSpeaker() {
    logger.info("getSpeaker()");        return "";
    }

    @Override
    public String getText() {
    logger.info("getText()");        return "";
    }

    @Override
    public void execute() {
    logger.info("execute()");        //TODO Items sollen im Inventar des Spielers landen.
        System.out.println("Item erhalten: " + itemName);
        // Dein Inventory-Manager wäre hier zuständig
    }
}

