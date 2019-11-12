package edu.austral.starship.base.framework;

import edu.austral.starship.base.interfaces.Collisionable;
import edu.austral.starship.base.interfaces.Destructible;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public abstract class GameObject implements Collisionable, Destructible {
    private Vector2 position;
    private Shape collider;
    private Visitor visitor;
    private boolean isAlive;

    public GameObject(Vector2 position, Shape collider) {
        this.position = position;
        this.collider = collider;
        isAlive = true;
    }

    public abstract void accept(Visitor visitor);

    @Override
    public Shape getShape() {
        return collider;
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {
        accept(visitor);
    }

    @Override
    public abstract void damage();

    @Override
    public void destroy() {
        isAlive = false;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
