package edu.austral.starship.components.projectile;

import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.CollisionsVisitor;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.interfaces.Moveable;
import edu.austral.starship.components._common.interfaces.Weaponized;

import java.awt.*;

public class Projectile extends GameObject {
    private static final int PROJECTILE_HEIGHT = 18;
    private static final int PROJECTILE_WIDTH = 5;
    private static final float PROJECTILE_SPEED = 10f;
    private static final CollisionsVisitor COLLISIONS_VISITOR = new ProjectileCollisionsVisitor();

    private float speed;
    private float size;
    private Weaponized shooter;

    public Projectile(Vector2 position, Vector2 direction, float size, Weaponized shooter) {
        super(position,
                direction,
                new Rectangle(
                        (int) position.x - PROJECTILE_WIDTH / 2,
                        (int) position.y - PROJECTILE_HEIGHT / 2,
                        PROJECTILE_WIDTH,
                        PROJECTILE_HEIGHT),
                COLLISIONS_VISITOR);
        this.setCollider(new Rectangle(
                (int) (position.x - (PROJECTILE_WIDTH * size / 2)),
                (int) (position.y - (PROJECTILE_HEIGHT * size / 2)),
                (int) (PROJECTILE_WIDTH * size),
                (int) (PROJECTILE_HEIGHT * size)));
        speed = PROJECTILE_SPEED;
        this.size = size;
        this.shooter = shooter;
    }

    @Override
    public void accept(CollisionsVisitor collisionsVisitor) {
        collisionsVisitor.visit(this);
    }

    @Override
    public void move() {
        setPosition(getPosition().substract(getDirection().unitary().multiply(speed)));
    }

    public Weaponized getShooter() {
        return shooter;
    }
}
