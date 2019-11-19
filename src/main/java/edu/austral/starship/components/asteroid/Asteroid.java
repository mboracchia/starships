package edu.austral.starship.components.asteroid;

import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class Asteroid extends GameObject {
    private static final int ASTEROID_HEIGHT = 40;
    private static final int ASTEROID_WIDTH = 40;
    private static final float ASTEROID_SPEED = 6f;
    private static final CollisionsVisitor COLLISIONS_VISITOR = new AsteroidCollisionsVisitor();

    private int size;
    private float speed;

    public Asteroid(Vector2 position, Vector2 direction) {
        super(position, direction, new Rectangle(
                        (int) position.x - ASTEROID_WIDTH / 2,
                        (int) position.y - ASTEROID_HEIGHT / 2,
                        ASTEROID_WIDTH,
                        ASTEROID_HEIGHT),
                COLLISIONS_VISITOR);
        size = (int) (Math.random() * 3) + 1;
        speed = (float) (Math.random() * ASTEROID_SPEED) + 1;
        this.setCollider(new Rectangle(
                (int) position.x - (ASTEROID_WIDTH * size / 2),
                (int) position.y - (ASTEROID_HEIGHT * size / 2),
                ASTEROID_WIDTH * size,
                ASTEROID_HEIGHT * size));
    }

    @Override
    public void accept(CollisionsVisitor collisionsVisitor) {
        collisionsVisitor.visit(this);
    }

    @Override
    public void move() {
        setPosition(getPosition().add(getDirection().unitary().multiply(speed)));
    }
}
