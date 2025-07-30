package core.factory;

import UI.MenuScreen;
import state.GameEventListener;

public interface ScreenFactory {
    MenuScreen createMenuScreen(GameEventListener listener);
}

