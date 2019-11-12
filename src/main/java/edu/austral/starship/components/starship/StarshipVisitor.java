package edu.austral.starship.components.starship;

import edu.austral.starship.base.interfaces.Consumable;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.projectile.Projectile;

public class StarshipVisitor implements Visitor {
    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(Projectile projectile) {
        projectile.damage();
    }

    @Override
    public void visit(Starship starship) {

    }

    @Override
    public void visit(Consumable consumable) {

    }
}
