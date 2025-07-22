package UI.GUI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;

public class DialogScreen extends Screen{

    private JPanel dialogContainer;
    private JScrollPane scrollPaneDialog;

    private JPanel optionContainer;
    private JScrollPane scrollPaneOptionen;


    @Override
    public void createScreen() {
        // Frame Einstellungen
        frame.setSize(displayDimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Panel Einstellungen
        panel.setBackground(backgroundColor);  // Hintergrundfarbe
        panel.setLayout(null);

        // === Header ===
        JLabel Header = new JLabel("domain");
        Header.setForeground(fontColor);
        Header.setFont(headerFont);
        Header.setBounds(350, 20, 300, 60);
        Header.setBorder(border);
        // ZENTRIERUNG des Textes im Label
        Header.setHorizontalAlignment(SwingConstants.CENTER);
        Header.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(Header);

        // === DialogContainer ===
        dialogContainer = new JPanel();
        dialogContainer.setLayout(new BoxLayout(dialogContainer, BoxLayout.Y_AXIS));
        dialogContainer.setBackground(backgroundColor);

        // === Dialog ScrollPane ===
        scrollPaneDialog = new JScrollPane(dialogContainer);
        scrollPaneDialog.setBounds(100, 100, 800, 200); // unter dem Header
        scrollPaneDialog.setBorder(border);  // optional
        scrollPaneDialog.getVerticalScrollBar().setUnitIncrement(20);//Scrollgeschwindigkeit
        scrollPaneDialog.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPaneDialog.getVerticalScrollBar().setPreferredSize(new Dimension(6, Integer.MAX_VALUE));
        panel.add(scrollPaneDialog);

        // === OptionContainer ===
        optionContainer = new JPanel();
        optionContainer.setLayout(new BoxLayout(optionContainer, BoxLayout.Y_AXIS));
        optionContainer.setBackground(backgroundColor);

        // === Dialog ScrollPane ===
        scrollPaneOptionen = new JScrollPane(optionContainer);
        scrollPaneOptionen.setBounds(100, 320, 800, 200); // unter dem Header
        scrollPaneOptionen.setBorder(border);  // optional
        scrollPaneOptionen.getVerticalScrollBar().setUnitIncrement(20);//Scrollgeschwindigkeit
        scrollPaneOptionen.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPaneOptionen.getVerticalScrollBar().setPreferredSize(new Dimension(6, Integer.MAX_VALUE));
        panel.add(scrollPaneOptionen);

        // === Fenster anzeigen ===
        frame.add(panel);
        frame.setVisible(true);
    }

    public void addDialog(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(fontColor);
        textArea.setFont(normalFont);
        textArea.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));  // innenabstand statt margin
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        textArea.setMaximumSize(new Dimension(750, Integer.MAX_VALUE));  // damit der Umbruch funktioniert

        // Abstand hinzufügen
        if (dialogContainer.getComponentCount() > 0) {
            dialogContainer.add(Box.createRigidArea(new Dimension(0, 4)));
        }

        dialogContainer.add(textArea);
        dialogContainer.revalidate();
        dialogContainer.repaint();

        // Automatisch nach unten scrollen
        SwingUtilities.invokeLater(() ->
                                           scrollPaneDialog.getVerticalScrollBar().setValue(scrollPaneDialog.getVerticalScrollBar().getMaximum()));
    }


    public void addOption(String text) {
        JButton btn = new JButton("- " + text);

        // Stil
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);  // zentriert in BoxLayout
        btn.setForeground(fontColor);
        btn.setBackground(backgroundColor);
        btn.setFont(normalFont);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(600, 28));  // flacher Button
        btn.setMaximumSize(new Dimension(600, 28));    // gleich festsetzen
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setVerticalAlignment(SwingConstants.CENTER);
        btn.setMargin(new Insets(0, 0, 0, 0));  // kein Innenabstand im Button


        // Beispiel: Button schreibt eigenen Text in den Dialog
        btn.addActionListener(e -> addDialog("Spieler: " + text));

        // Abstand davor
        optionContainer.add(Box.createRigidArea(new Dimension(7, 10))); // Breite 0, Höhe 3
        optionContainer.add(btn);

        optionContainer.revalidate();
        optionContainer.repaint();
    }





}
