package core;

import org.slf4j.Logger;

public class GameContext {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GameContext.class);
    private StateManager stateManager;
    // ... weitere Felder

    public StateManager getStateManager() {
    logger.info("getStateManager()");
        return stateManager;
    }
    public void setStateManager(StateManager stateManager) {
    logger.info("setStateManager()");        logger.info("setStateManager({})", stateManager);
        this.stateManager = stateManager; }

    // ...
}
