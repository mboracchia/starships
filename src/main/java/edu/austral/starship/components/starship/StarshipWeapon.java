package edu.austral.starship.components.starship;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components._common.interfaces.Shootable;
import edu.austral.starship.components._common.interfaces.Upgradable;
import edu.austral.starship.components._common.interfaces.Weaponized;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.projectile.ProjectileController;
import edu.austral.starship.components.projectile.ProjectileFactory;

/**
 * Has a replaceable projectile factory.
 */
public class StarshipWeapon implements Upgradable, Shootable {
    private final static int STARTING_SHOOTING_SPEED = 15;
    private final static float STARTING_SHOOTING_SIZE = 1f;

    private int shootingSpeed;
    private float shootingSize;
    private ProjectileFactory projectileFactory;

    public StarshipWeapon() {
        projectileFactory = new ProjectileFactory();
        shootingSpeed = STARTING_SHOOTING_SPEED;
        shootingSize = STARTING_SHOOTING_SIZE;
    }

    @Override
    public void addUpgrade(Consumable consumable) {
        consumable.upgrade(this);
    }

    @Override
    public ProjectileController shoot(Vector2 position, Vector2 direction, Weaponized shooter) {
        return projectileFactory.make(position, direction, shootingSize, shooter);
    }

    public int getShootingSpeed() {
        return shootingSpeed;
    }

    public void setShootingSpeed(int shootingSpeed) {
        this.shootingSpeed = shootingSpeed;
    }

    public ProjectileFactory getProjectileFactory() {
        return projectileFactory;
    }

    public void setProjectileFactory(ProjectileFactory projectileFactory) {
        this.projectileFactory = projectileFactory;
    }

    public float getShootingSize() {
        return shootingSize;
    }

    public void setShootingSize(float shootingSize) {
        this.shootingSize = shootingSize;
    }
}
