package edu.austral.starship.components.projectile;

import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.starship.Starship;

public class ProjectileCollisionsVisitor implements CollisionsVisitor {
    @Override
    public void visit(Asteroid asteroid) {
        asteroid.damage();
    }

    @Override
    public void visit(Projectile projectile) {

    }

    @Override
    public void visit(Starship starship) {
        starship.damage();
    }

    @Override
    public void visit(Consumable consumable) {

    }
}
