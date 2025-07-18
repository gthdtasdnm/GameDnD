package main.UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel screenContainer;

    public GameFrame() {
        setTitle("Mein Spiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        screenContainer = new JPanel(cardLayout);

        // Screens erstellen
        MenuScreen menu = new MenuScreen(this);
        ExploreScreen explore = new ExploreScreen(this);
        FightScreen fight = new FightScreen(this);
        DialogScreen dialog = new DialogScreen(this);

        // Screens hinzufügen
        screenContainer.add(menu, "menu");
        screenContainer.add(explore, "explore");
        screenContainer.add(fight, "fight");
        screenContainer.add(dialog, "dialog");

        setContentPane(screenContainer);
    }

    public void showScreen(String name) {
        cardLayout.show(screenContainer, name);
    }
}

