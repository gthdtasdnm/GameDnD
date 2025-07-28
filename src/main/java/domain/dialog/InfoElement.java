package domain.dialog;

/**
 * Das {@code InfoElement}-Interface definiert ein ausführbares Dialogelement.
 *
 * <p>Alle Klassen, die {@code InfoElement} implementieren (z. B. {@link DialogLine}),
 * müssen eine {@code execute()}-Methode bereitstellen, die beim Aufruf
 * eine bestimmte Dialogaktion ausführt.</p>
 *
 * <p>Wird in {@link Information} verwendet, um einzelne Bestandteile eines Dialogs zu verwalten.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */

public interface InfoElement {
    String getSpeaker();
    String getText();
    void execute();
}
