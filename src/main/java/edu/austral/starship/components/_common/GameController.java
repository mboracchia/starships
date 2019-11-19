package edu.austral.starship.components._common;

import processing.core.PGraphics;
import processing.core.PImage;

public abstract class GameController {
    private GameObject gameObject;
    private GameView gameView;

    public GameController(GameObject gameObject, GameView gameView) {
        this.gameObject = gameObject;
        this.gameView = gameView;
    }

    public void render(PGraphics graphics) {
        if (gameObject.isAlive()) {
            gameView.render(graphics,
                    gameObject.getShape().getBounds().x,
                    gameObject.getShape().getBounds().y,
                    gameObject.getShape().getBounds().height,
                    gameObject.getShape().getBounds().width,
                    gameObject.getDirection().unitary().angle());
        }
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setImage(PImage image) {
        gameView.setImage(image);
    }

    public boolean isAlive() {
        return gameObject.isAlive();
    }

    public void move() {
        gameObject.move();
    }
}
