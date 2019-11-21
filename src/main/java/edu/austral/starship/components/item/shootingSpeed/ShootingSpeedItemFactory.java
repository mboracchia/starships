package edu.austral.starship.components.item.shootingSpeed;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components.item.Item;
import edu.austral.starship.components.item.ItemCollisionsVisitor;
import edu.austral.starship.components.item.ItemController;
import edu.austral.starship.components.item.ItemFactory;
import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.components.starship.StarshipWeapon;

public class ShootingSpeedItemFactory extends ItemFactory {
    @Override
    public ItemController make() {
        return new ItemController(new ShootingSpeedItem(randomVector()));
    }
}
