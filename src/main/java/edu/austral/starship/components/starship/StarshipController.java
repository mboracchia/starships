package edu.austral.starship.components.starship;

import edu.austral.starship.base.framework.GameController;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class StarshipController extends GameController {
    public StarshipController(Vector2 pos, Shape collider) {
        super(new Starship(pos, collider), new StarshipView());
    }
}
