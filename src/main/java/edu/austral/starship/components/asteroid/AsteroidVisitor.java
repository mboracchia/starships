package edu.austral.starship.components.asteroid;

import edu.austral.starship.base.interfaces.Consumable;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.base.vector.Vector2;

public class AsteroidVisitor implements Visitor {
    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(Projectile projectile) {
        projectile.damage();
    }

    @Override
    public void visit(Starship starship) {
        starship.damage();
        starship.setPosition(Vector2.vector(0, 0));
    }

    @Override
    public void visit(Consumable consumable) {

    }
}
