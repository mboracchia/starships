package edu.austral.starship.components._common;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.components._common.interfaces.Destructible;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.Moveable;

import java.awt.*;

public abstract class GameObject implements Collisionable<GameObject>, Destructible, Moveable {
    private Vector2 position;
    private Vector2 direction;
    private Shape collider;
    private CollisionsVisitor collisionVisitor;
    private boolean isAlive;

    public GameObject(Vector2 position, Vector2 direction, Shape collider, CollisionsVisitor collisionVisitor) {
        this.position = position;
        this.direction = direction;
        this.collider = collider;
        this.collisionVisitor = collisionVisitor;
        isAlive = true;
    }

    @Override
    public Shape getShape() {
        return collider;
    }

    @Override
    public void collisionedWith(GameObject collisionable) {
        collisionable.accept(getCollisionVisitor());
    }

    @Override
    public void damage() {
        destroy();
    }

    @Override
    public void destroy() {
        isAlive = false;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public abstract void accept(CollisionsVisitor visitor);

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public Shape getCollider() {
        return collider;
    }

    public CollisionsVisitor getCollisionVisitor() {
        return collisionVisitor;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        setCollider(new Rectangle(
                (int) getPosition().x - getCollider().getBounds().width / 2,
                (int) getPosition().y - getCollider().getBounds().height / 2,
                getCollider().getBounds().width,
                getCollider().getBounds().height));
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public void setCollider(Shape collider) {
        this.collider = collider;
    }

    public void setCollisionVisitor(CollisionsVisitor collisionVisitor) {
        this.collisionVisitor = collisionVisitor;
    }
}
