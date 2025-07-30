package core;

import core.factory.ScreenFactory;
import data.DialogRepository;
import org.slf4j.Logger;

public class GameContext {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GameContext.class);
    private StateManager stateManager;
    private ScreenFactory screenFactory;
    private DialogRepository dialogRepository;
    // ... weitere Felder

    public StateManager getStateManager() {
    logger.info("getStateManager()");
        return stateManager;
    }
    public void setStateManager(StateManager stateManager) {
    logger.info("setStateManager()");        logger.info("setStateManager({})", stateManager);
        this.stateManager = stateManager; }

    public ScreenFactory getScreenFactory() {
        return screenFactory;
    }

    public void setScreenFactory(ScreenFactory screenFactory) {
        this.screenFactory = screenFactory;
    }


    public DialogRepository getDialogRepository() {
        return dialogRepository;
    }

    public void setDialogRepository(DialogRepository dialogRepository) {
        this.dialogRepository = dialogRepository;
    }
    // ...
}
