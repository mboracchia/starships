package edu.austral.starship.components.projectile;

import edu.austral.starship.base.vector.Vector2;

public class ProjectileFactory {
    public ProjectileController make(Vector2 position, Vector2 direction, float size) {
        return new ProjectileController(new Projectile(position, direction, size));
    }
}
