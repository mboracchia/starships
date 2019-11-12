package edu.austral.starship.components.asteroid;

import edu.austral.starship.base.framework.GameController;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class AsteroidController extends GameController {
    public AsteroidController(Vector2 pos, Shape collider) {
        super(new Asteroid(pos, collider), new AsteroidView());
    }
}
