package UI.GUI;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Die Klasse {@code ModernScrollBarUI} definiert ein minimalistisches
 * und modernes Design für vertikale Scrollleisten.
 *
 * <p>Sie erweitert {@link javax.swing.plaf.basic.BasicScrollBarUI} und überschreibt
 * Farben, Größe und Sichtbarkeit der Scrollbar-Komponenten:</p>
 *
 * <ul>
 *   <li>Weiße Daumenfarbe ({@code thumbColor})</li>
 *   <li>Schwarzer Hintergrund ({@code trackColor})</li>
 *   <li>Versteckte Pfeilbuttons (zurückgesetzt auf 0x0 Größe)</li>
 *   <li>Schmale Scrollbar mit fester Breite (6 Pixel)</li>
 * </ul>
 *
 * <p>Wird u. a. in {@link DialogScreen} zur stilistischen Anpassung verwendet.</p>
 *
 * @author Cengiz
 * @since 2025-07-22
 */


public class ModernScrollBarUI extends BasicScrollBarUI {

    @Override
    protected void configureScrollBarColors() {
        thumbColor = Color.WHITE;           // Scroll-Griff (Daumen)
        trackColor = Color.BLACK;           // Hintergrund
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        button.setVisible(false);
        return button;
    }


    protected Dimension getThumbSize() {
        return new Dimension(6, 60); // Breite der Scrollleiste
    }
}

