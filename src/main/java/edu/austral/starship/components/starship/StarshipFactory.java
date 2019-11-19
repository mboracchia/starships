package edu.austral.starship.components.starship;

import edu.austral.starship.base.vector.Vector2;

public class StarshipFactory {
    public StarshipController make(int x, int y) {
        return new StarshipController(Vector2.vector(x, y));
    }
}
