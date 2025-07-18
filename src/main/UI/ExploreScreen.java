package main.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExploreScreen extends JPanel {
    private final int rows = 10;
    private final int cols = 10;
    private int playerX = 5;
    private int playerY = 5;

    public ExploreScreen(GameFrame game) {
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600, 600));

        // Tastatur-Eingaben
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (playerY > 0) playerY--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (playerY < rows - 1) playerY++;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (playerX > 0) playerX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (playerX < cols - 1) playerX++;
                        break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = getWidth() / cols;

        // Zeichne Gitter
        g.setColor(Color.GRAY);
        for (int i = 0; i <= cols; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize);
        }
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize);
        }

        // Spieler zeichnen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, cellSize));
        int xPixel = playerX * cellSize;
        int yPixel = (playerY + 1) * cellSize - 4; // kleiner Offset nach unten
        g.drawString("@", xPixel + 4, yPixel);
    }
}

