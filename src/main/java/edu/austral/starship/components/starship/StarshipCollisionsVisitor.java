package edu.austral.starship.components.starship;

import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.projectile.Projectile;

public class StarshipCollisionsVisitor implements CollisionsVisitor {
    @Override
    public void visit(Asteroid asteroid) {
        asteroid.damage();
    }

    @Override
    public void visit(Projectile projectile) {
        projectile.damage();
    }

    @Override
    public void visit(Starship starship) {}

    @Override
    public void visit(Consumable consumable) {
        GameObject gameObject = (GameObject) consumable;
        gameObject.damage();
    }
}
