package edu.austral.starship.components.item.starshipLife;

import edu.austral.starship.components.item.ItemController;
import edu.austral.starship.components.item.ItemFactory;
import edu.austral.starship.components.item.shootingSpeed.ShootingSpeedItem;

public class StarshipLifeItemFactory extends ItemFactory {
    @Override
    public ItemController make() {
        return new ItemController(new StarshipLifeItem(randomVector()));
    }
}
