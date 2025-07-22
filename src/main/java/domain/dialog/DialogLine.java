package domain.dialog;

/**
 * Die Klasse {@code DialogLine} repräsentiert eine einzelne Zeile in einem Dialog.
 *
 * <p>Sie implementiert das {@link InfoElement}-Interface und gibt beim Ausführen
 * den enthaltenen Text über {@code System.out} aus.</p>
 *
 * <p>Jede Dialogzeile besitzt eine eindeutige ID und den eigentlichen Textinhalt.</p>
 *
 * <p>Wird typischerweise in {@code Information} verwendet, um Dialoge Schritt für Schritt darzustellen.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class DialogLine implements InfoElement{
    private String id;
    private String text;

    public DialogLine(String id, String text){
        this.id = id;
        this.text = text;
    }

    public String getId(){return id;}

    public String getText(){return text;}

    @Override
    public void execute() {
        System.out.println(text);
    }
}
