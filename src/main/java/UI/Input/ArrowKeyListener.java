package UI.Input;

import UI.GUI.MapScreen;
import core.PlayerController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeyListener extends KeyAdapter {
    private final PlayerController controller;
    private final MapScreen mapScreen;

    public ArrowKeyListener(PlayerController controller, MapScreen mapScreen) {
        this.controller = controller;
        this.mapScreen = mapScreen;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> controller.movePlayer(0, -1);
            case KeyEvent.VK_S -> controller.movePlayer(0, 1);
            case KeyEvent.VK_A -> controller.movePlayer(-1, 0);
            case KeyEvent.VK_D -> controller.movePlayer(1, 0);
        }
        mapScreen.renderMap(); // damit die neue Position angezeigt wird
    }
}


