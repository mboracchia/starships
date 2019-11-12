package edu.austral.starship.components.starship;

import edu.austral.starship.base.interfaces.Consumable;
import edu.austral.starship.base.interfaces.Upgradable;

/**
 * Has a replaceable projectile factory.
 */
public class StarshipWeapon implements Upgradable {
    int shootingSpeed;

    @Override
    public void addUpgrade(Consumable consumable) {
        consumable.upgrade(this);
    }
}
