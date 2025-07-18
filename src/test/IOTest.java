package test;

import main.UI.LanternaMenuDemo;
import main.UI.LanternaUIDemo;
import main.UI.LanternaWindow;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IOTest {

    @Test
    public void IOLanternaTest() throws IOException {
        LanternaUIDemo LaternaUIDemo = new LanternaUIDemo();
        LaternaUIDemo.IO();
    }

    @Test
    public void IOLanternaMenuTest() throws IOException {
        LanternaMenuDemo LaternaMenuDemo = new LanternaMenuDemo();
        LaternaMenuDemo.Menu();
    }

    @Test
    public void IOLanternaWindowTest() throws IOException{
        LanternaWindow lanternaWindow = new LanternaWindow();
        lanternaWindow.window();
    }
}
