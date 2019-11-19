package edu.austral.starship.components.asteroid;

import edu.austral.starship.base.vector.Vector2;

import java.util.Random;

public class AsteroidFactory {
    Random random = new Random();

    public AsteroidController make() {
        float positionX = (float) ((Math.random() * 720) - 360 + (Math.random() * 180));
        float positionY;
        float directionX = random.nextFloat();
        float directionY = random.nextFloat();
        if (random.nextFloat() > .5) {
            positionY = 360f;
        } else {
            positionY = -360f;
        }
        if (random.nextFloat() < .5) {
            directionX = -directionX;
        }
        Vector2 position = Vector2.vector(positionX, positionY);
        Vector2 direction;
        if (positionY > 0) {
            direction = Vector2.vector(directionX, -directionY).unitary();
        } else {
            direction = Vector2.vector(directionX, directionY).unitary();
        }
        return new AsteroidController(position, direction);
    }
}
