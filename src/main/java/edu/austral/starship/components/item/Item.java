package edu.austral.starship.components.item;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.interfaces.Consumable;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public abstract class Item extends GameObject implements Consumable {
    double dropProbability;

    public Item(Vector2 position, Shape collider) {
        super(position, collider);
    }
}
