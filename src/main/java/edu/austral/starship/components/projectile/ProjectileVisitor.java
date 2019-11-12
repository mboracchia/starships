package edu.austral.starship.components.projectile;

import edu.austral.starship.base.interfaces.Consumable;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.starship.Starship;

public class ProjectileVisitor implements Visitor {
    @Override
    public void visit(Asteroid asteroid) {
        asteroid.damage();
    }

    @Override
    public void visit(Projectile projectile) {

    }

    @Override
    public void visit(Starship starship) {

    }

    @Override
    public void visit(Consumable consumable) {

    }
}
