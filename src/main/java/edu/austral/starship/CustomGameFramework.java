package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.components.starship.StarshipController;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    private int WINDOW_WIDTH = 500;
    private int WINDOW_HEIGHT = 500;

    private int UP_ARROW = 38;
    private int RIGHT_ARROW = 39;
    private int DOWN_ARROW = 40;
    private int LEFT_ARROW = 37;
    private int SPACEBAR = 32;

    private CollisionEngine collisionEngine;

    private List<GameObject> gameObjects;

    StarshipController starshipController;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
