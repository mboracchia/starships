package edu.austral.starship.components.starship;

import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.*;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components.asteroid.Asteroid;
import edu.austral.starship.components.projectile.ProjectileController;

import java.awt.*;

public class Starship extends GameObject implements Controllable, Upgradable, Weaponized {
    private static final int STARSHIP_HEIGHT = 40;
    private static final int STARSHIP_WIDTH = 40;
    private static final int STARTING_LIVES = 6;
    private static final float STARTING_SPEED = 5f;
    private static final Vector2 STARTING_DIRECTION = Vector2.vector(0, 1);
    private static final CollisionsVisitor COLLISIONS_VISITOR = new StarshipCollisionsVisitor();

    private int lives;
    private int score;
    private float speed;
    private StarshipWeapon starshipWeapon;

    public Starship(Vector2 position) {
        super(position,
                STARTING_DIRECTION,
                new Rectangle(
                        (int) position.x - STARSHIP_WIDTH / 2,
                        (int) position.y - STARSHIP_HEIGHT / 2,
                        STARSHIP_WIDTH,
                        STARSHIP_HEIGHT),
                COLLISIONS_VISITOR);
        lives = STARTING_LIVES;
        score = 0;
        speed = STARTING_SPEED;
        starshipWeapon = new StarshipWeapon();
    }

    @Override
    public void accept(CollisionsVisitor collisionsVisitor) {
        collisionsVisitor.visit(this);
    }

    @Override
    public void damage() {
        if (lives > 1) {
            lives--;
            setPosition(Vector2.vector(0, 0));
        } else {
            destroy();
        }
    }

    @Override
    public void move() {

    }

    @Override
    public void rotateLeft() {
        setDirection(getDirection().rotate(-0.1f).unitary());
    }

    @Override
    public void rotateRight() {
        setDirection(getDirection().rotate(+0.1f).unitary());
    }

    @Override
    public void moveForward() {
        setPosition(getNewPosition(true));
    }

    @Override
    public void moveBackwards() {
        setPosition(getNewPosition(false));
    }

    @Override
    public void addUpgrade(Consumable consumable) {
        consumable.upgrade(this);
        consumable.upgrade(starshipWeapon);
    }

    @Override
    public ProjectileController shoot(Shootable starshipWeapon) {
        Vector2 position = Vector2.vector(
                getPosition().x - getDirection().multiply((float) STARSHIP_WIDTH / 2).x,
                getPosition().y - getDirection().multiply((float) STARSHIP_HEIGHT).y);
        Vector2 direction = Vector2.vector(getDirection().x, getDirection().y);
        return starshipWeapon.shoot(position, direction, this);
    }

    @Override
    public void targetHit() {
        addScore(Asteroid.getAsteroidScore());
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public StarshipWeapon getStarshipWeapon() {
        return starshipWeapon;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    private Vector2 getNewPosition(boolean forward) {
        float x;
        float y;
        if (forward) {
            Vector2 vector = getPosition().substract(getDirection().unitary().multiply(speed));
            if (vector.x > 360) {
                x = -360f;
            } else if (vector.x < -360) {
                x = 360f;
            } else {
                x = vector.x;
            }
            if (vector.y > 360) {
                y = -360f;
            } else if (vector.y < -360) {
                y = 360f;
            } else {
                y = vector.y;
            }
        } else {
            Vector2 vector = getPosition().add(getDirection().unitary().multiply(speed));
            if (vector.x > 360) {
                x = -360f;
            } else if (vector.x < -360) {
                x = 360f;
            } else {
                x = vector.x;
            }
            if (vector.y > 360) {
                y = -360f;
            } else if (vector.y < -360) {
                y = 360f;
            } else {
                y = vector.y;
            }
        }
        return Vector2.vector(x, y);
    }
}
