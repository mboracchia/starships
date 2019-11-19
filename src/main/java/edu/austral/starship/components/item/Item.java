package edu.austral.starship.components.item;

import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components.asteroid.AsteroidCollisionsVisitor;
import edu.austral.starship.components.starship.StarshipCollisionsVisitor;

import java.awt.*;

public abstract class Item extends GameObject implements Consumable {
    private static final int ITEM_HEIGHT = 40;
    private static final int ITEM_WIDTH = 40;
    private static final float DROP_PROBABILITY = 0.1f;

    float dropProbability;
    float value;

    public Item(Vector2 position, float value) {
        super(position,
                Vector2.vector(0, 1),
                new Rectangle(
                        (int) position.x - ITEM_WIDTH / 2,
                        (int) position.y - ITEM_HEIGHT / 2,
                        ITEM_WIDTH,
                        ITEM_HEIGHT),
                new ItemCollisionsVisitor());
        this.dropProbability = DROP_PROBABILITY;
        this.value = value;
    }

    public static float getDropProbability() {
        return DROP_PROBABILITY;
    }

    public float getValue() {
        return value;
    }
}
