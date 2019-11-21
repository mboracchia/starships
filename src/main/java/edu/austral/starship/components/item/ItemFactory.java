package edu.austral.starship.components.item;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components.item.shootingSpeed.ShootingSpeedItem;
import edu.austral.starship.components.item.starshipLife.StarshipLifeItem;

import java.util.Random;

public abstract class ItemFactory {
    Random random = new Random();

    public abstract ItemController make();

    protected Vector2 randomVector() {
        float positionX = (float) ((Math.random() * 540) - 270);
        float positionY = (float) ((Math.random() * 540) - 270);
        return Vector2.vector(positionX, positionY);
    }
}
