package edu.austral.starship.components.item;

import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.item.shootingSize.ShootingSizeItem;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.starship.Starship;

public class ItemCollisionsVisitor implements CollisionsVisitor {
    private Consumable consumable;

    @Override
    public void visit(Asteroid asteroid) {}

    @Override
    public void visit(Projectile projectile) {}

    @Override
    public void visit(Starship starship) {
        starship.addUpgrade(consumable);
        starship.getStarshipWeapon().addUpgrade(consumable);
    }

    @Override
    public void visit(Consumable consumable) {

    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }
}
