package domain.dialog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Die Klasse {@code Information} verwaltet eine Sequenz von {@link InfoElement}-Objekten,
 * die schrittweise im Dialogverlauf ausgeführt werden.
 *
 * <p>Die Dialogelemente (z. B. {@link DialogLine}) werden in einer Queue gespeichert
 * und über {@code processAll()} nacheinander ausgeführt.</p>
 *
 * <p>Wird in {@link DialogInstance} eingesetzt, um das Verhalten beim Auswählen
 * einer Dialogoption zu steuern.</p>
 *
 * <p>Typische Nutzung:</p>
 * <pre>{@code
 * Information info = new Information();
 * info.add(new DialogLine("greet", "Hallo Fremder."));
 * info.processAll(); // Gibt die Zeilen nacheinander aus
 * }</pre>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class Information {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Information.class);
    private Queue<InfoElement> elements = new LinkedList<>();

    public Information(){

    }
    public void add(InfoElement element) {
    logger.info("add()");        elements.offer(element);
    }

    public void processAll() {
    logger.info("processAll()");        while (!elements.isEmpty()) {
            InfoElement next = elements.poll();
            next.execute();
        }
    }

    public Queue<InfoElement> getElements(){
    logger.info("getElements()");        return elements;
    }

    public boolean isEmpty() {
    logger.info("isEmpty()");        return elements.isEmpty();
    }
}
