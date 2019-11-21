package edu.austral.starship.components.asteroid;

import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.base.vector.Vector2;

import static processing.core.PApplet.radians;

public class AsteroidCollisionsVisitor implements CollisionsVisitor {
    @Override
    public void visit(Asteroid asteroid) {}

    @Override
    public void visit(Projectile projectile) {
        projectile.getShooter().targetHit();
        projectile.damage();
    }

    @Override
    public void visit(Starship starship) {
        starship.damage();
    }

    @Override
    public void visit(Consumable consumable) {

    }
}
