package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public abstract class Screen {
    protected JFrame frame = new JFrame();
    protected JPanel panel = new JPanel();


    //Design preset
    protected Dimension displayDimensions = new Dimension(1000, 600);
    protected Color fontColor = Color.WHITE;
    protected Color backgroundColor = Color.BLACK;
    protected Font headerFont = new Font("Arial", Font.PLAIN, 40);
    protected Font normalFont = new Font("Arial", Font.PLAIN, 20);
    protected LineBorder border = new LineBorder(Color.WHITE, 2);


    abstract public void createScreen();

    public Component getFrame() {return frame;}

    public void closeScreen() {
        frame.dispose();
    }
}

