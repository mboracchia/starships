package edu.austral.starship.components.item.starshipLife;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components.item.Item;
import edu.austral.starship.components.item.ItemCollisionsVisitor;
import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.components.starship.StarshipWeapon;

public class StarshipLifeItem extends Item {
    private static final float UPGRADE_VALUE = 1.0f;

    public StarshipLifeItem(Vector2 position) {
        super(position, UPGRADE_VALUE);
        ItemCollisionsVisitor itemCollisionsVisitor = (ItemCollisionsVisitor) getCollisionVisitor();
        itemCollisionsVisitor.setConsumable(this);
    }

    @Override
    public void accept(CollisionsVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void upgrade(Starship starship) {
        starship.setLives(starship.getLives() + (int) getValue());
    }

    @Override
    public void upgrade(StarshipWeapon starshipWeapon) {}

    @Override
    public void move() {

    }
}
