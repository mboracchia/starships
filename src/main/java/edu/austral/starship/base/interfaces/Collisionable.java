package edu.austral.starship.base.interfaces;

import java.awt.*;

public interface Collisionable<T extends Collisionable<T>> {
    Shape getShape();

    void collisionedWith(T collisionable);
}
