package UI;

import javax.swing.*;

public class ScreenManager {
    private static MainFrame mainFrame;

    public static void init(MainFrame frame) {
        mainFrame = frame;
    }

    public static void showScreen(JPanel screen) {
        mainFrame.switchScreen(screen);
    }
}
