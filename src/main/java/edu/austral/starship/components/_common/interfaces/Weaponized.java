package edu.austral.starship.components._common.interfaces;

import edu.austral.starship.components.projectile.ProjectileController;

public interface Weaponized {
    ProjectileController shoot(Shootable shootable);

    void targetHit();
}
