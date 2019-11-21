package edu.austral.starship.components.projectile;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.Weaponized;

public class ProjectileFactory {
    public ProjectileController make(Vector2 position, Vector2 direction, float size, Weaponized shooter) {
        return new ProjectileController(new Projectile(position, direction, size, shooter));
    }
}
