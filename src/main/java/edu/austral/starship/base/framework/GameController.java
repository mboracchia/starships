package edu.austral.starship.base.framework;

import processing.core.PGraphics;

public abstract class GameController {
    private GameObject gameObject;
    private GameView gameView;

    public GameController(GameObject gameObject, GameView gameView) {
        this.gameObject = gameObject;
        this.gameView = gameView;
    }

    public void render(PGraphics graphics) {
        if(gameObject.isAlive()) {
            gameView.render(graphics, gameObject);
        }
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameView getGameView() {
        return gameView;
    }
}
