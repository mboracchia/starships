package edu.austral.starship.components.asteroid;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class Asteroid extends GameObject {
    private int size;

    public Asteroid(Vector2 position, Shape collider) {
        super(position, collider);
        size = (int) (Math.random() * 3) + 1;
        setVisitor(new AsteroidVisitor());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void damage() {
        destroy();
    }
}
