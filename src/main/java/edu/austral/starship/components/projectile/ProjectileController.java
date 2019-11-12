package edu.austral.starship.components.projectile;

import edu.austral.starship.base.framework.GameController;

public class ProjectileController extends GameController {
    public ProjectileController(Projectile projectile) {
        super(projectile, new ProjectileView());
    }
}
