package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

public class StartScreen extends Screen{
    public void createScreen(){
        // Frame Einstellungen
        frame.setSize(displayDimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

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

        JButton startGameButton = new JButton("Start new Game");
        startGameButton.setForeground(fontColor);
        startGameButton.setFont(normalFont);
        startGameButton.setBounds(400,130,200,50);
        startGameButton.setBackground(backgroundColor);
        startGameButton.setBorder(border);
        startGameButton.setFocusPainted(false);//sonst ist eine box im button
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(startGameButton);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);  // Hintergrundfarbe
        panel.setLayout(null);

        frame.add(panel);

        frame.setVisible(true);
    }
}
