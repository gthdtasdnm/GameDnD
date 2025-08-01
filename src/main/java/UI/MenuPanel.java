package UI;

import state.GameEventListener;
import state.MenuState;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JPanel panel;
    //Design preset
    protected Dimension displayDimensions = new Dimension(1000, 600);
    protected Color fontColor = Color.WHITE;
    protected Color backgroundColor = Color.BLACK;
    protected Font headerFont = new Font("Arial", Font.PLAIN, 40);
    protected Font normalFont = new Font("Arial", Font.PLAIN, 20);
    protected LineBorder border = new LineBorder(Color.WHITE, 2);

    public MenuPanel() {
        panel = new JPanel();
        //Alles hinzufügen #####################################

        JLabel Header = new JLabel("Hauptmenü");
        Header.setForeground(fontColor);
        Header.setFont(headerFont);
        Header.setBounds(350, 50, 300, 60);
        Header.setBorder(border);
        // ZENTRIERUNG des Textes im Label
        Header.setHorizontalAlignment(SwingConstants.CENTER);
        Header.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(Header);


        //Start Knopf
        JButton startGameButton = new JButton("Start new Game");
        //startGameButton.addActionListener(e -> listener.onUiAction("start_game"));//Übergibt ActionID um Im MenuState state zu wechseln
        startGameButton.setForeground(fontColor);
        startGameButton.setFont(normalFont);
        startGameButton.setBounds(400,130,200,50);
        startGameButton.setBackground(backgroundColor);
        startGameButton.setBorder(border);
        startGameButton.setFocusPainted(false);//sonst ist eine box im button
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(startGameButton);

        //Exit Knopf
        JButton exitGameButton = new JButton("Exit Game");
        //exitGameButton.addActionListener(e -> listener.onUiAction("exit_game"));
        exitGameButton.setForeground(fontColor);
        exitGameButton.setFont(normalFont);
        exitGameButton.setBounds(400,200,200,50);
        exitGameButton.setBackground(backgroundColor);
        exitGameButton.setBorder(border);
        exitGameButton.setFocusPainted(false);//sonst ist eine box im button
        exitGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitGameButton.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(exitGameButton);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);  // Hintergrundfarbe
        panel.setLayout(null);
    }

    public JPanel getPanel() {
        return panel;
    }
}

