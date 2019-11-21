package edu.austral.starship.components._common.interfaces;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components.projectile.ProjectileController;

public interface Shootable {
    ProjectileController shoot(Vector2 position, Vector2 direction, Weaponized shooter);
}
