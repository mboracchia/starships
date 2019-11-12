package edu.austral.starship.base.interfaces;

import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.starship.Starship;

public interface Visitor {
    void visit(Asteroid asteroid);

    void visit(Projectile projectile);

    void visit(Starship starship);

    void visit(Consumable consumable);
}
