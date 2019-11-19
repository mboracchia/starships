package edu.austral.starship.components.item;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components.item.shootingSize.ShootingSizeItem;
import edu.austral.starship.components.item.shootingSpeed.ShootingSpeedItem;
import edu.austral.starship.components.item.starshipLife.StarshipLifeItem;

import java.util.Random;

public class ItemFactory {
    Random random = new Random();

    public ItemController make() {
        float rnd = random.nextFloat();
        float positionX = (float) ((Math.random() * 540) - 270);
        float positionY = (float) ((Math.random() * 540) - 270);
        Vector2 position = Vector2.vector(positionX, positionY);
        Item newItem;
        if(rnd < .5) {
            newItem = new ShootingSpeedItem(position);
        } else {
            newItem = new StarshipLifeItem(position);
        }
        return new ItemController(newItem);
    }
}
