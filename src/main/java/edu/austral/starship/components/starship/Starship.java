package edu.austral.starship.components.starship;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.interfaces.*;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class Starship extends GameObject implements Controllable, Upgradable, Weaponized {
    private int lives;
    private StarshipWeapon starshipWeapon;

    public Starship(Vector2 position, Shape collider) {
        super(position, collider);
        starshipWeapon = new StarshipWeapon();
        setVisitor(new StarshipVisitor());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void damage() {
        if(lives > 1) {
            lives--;
        } else {
            destroy();
        }
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void moveForward() {

    }

    @Override
    public void moveBackwards() {

    }

    @Override
    public void addUpgrade(Consumable consumable) {
        consumable.upgrade(this);
        consumable.upgrade(starshipWeapon);
    }

    @Override
    public void shoot() {
    }
}
