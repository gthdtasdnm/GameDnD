package UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeyListener extends KeyAdapter {
    MapScreen mapScreen;
    public ArrowKeyListener(MapScreen mapScreen) {
        this.mapScreen = mapScreen;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> mapScreen.movePlayer(0,-1);
            case KeyEvent.VK_DOWN -> mapScreen.movePlayer(0,1);
            case KeyEvent.VK_LEFT -> mapScreen.movePlayer(-1,0);
            case KeyEvent.VK_RIGHT -> mapScreen.movePlayer(1,0);
            default -> System.out.println("Andere Taste: " + e.getKeyChar());
        }
    }
}

