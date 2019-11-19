package edu.austral.starship.components.asteroid;

import edu.austral.starship.components._common.GameController;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.GameView;
import processing.core.PGraphics;

import java.awt.*;

public class AsteroidController extends GameController {
    public AsteroidController(Vector2 position, Vector2 direction) {
        super(new Asteroid(position, direction), new AsteroidView());
    }

    @Override
    public void render(PGraphics graphics) {
        Vector2 position = getGameObject().getPosition();
        if(position.x > 360 || position.x < -360 || position.y > 360 || position.y < -360) {
            getGameObject().destroy();
        } else {
            super.render(graphics);
        }
    }
}
