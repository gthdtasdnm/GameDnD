package UI;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

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

