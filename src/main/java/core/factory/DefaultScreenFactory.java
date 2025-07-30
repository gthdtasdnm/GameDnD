package core.factory;

import UI.MenuScreen;
import state.GameEventListener;

public class DefaultScreenFactory implements ScreenFactory {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DefaultScreenFactory.class);
    @Override
    public MenuScreen createMenuScreen(GameEventListener listener) {
        logger.info("createMenuScreen()");
        return new MenuScreen(listener);
    }
}

