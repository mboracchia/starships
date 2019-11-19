package edu.austral.starship.components._common.interfaces;

import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.starship.Starship;

public interface CollisionsVisitor {
    void visit(Asteroid asteroid);

    void visit(Projectile projectile);

    void visit(Starship starship);

    void visit(Consumable consumable);
}
