package edu.austral.starship.components.starship;

import edu.austral.starship.components._common.GameController;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.GameView;
import edu.austral.starship.components._common.interfaces.Consumable;
import edu.austral.starship.components._common.interfaces.Controllable;
import edu.austral.starship.components._common.interfaces.Upgradable;
import edu.austral.starship.components._common.interfaces.Weaponized;
import edu.austral.starship.components.projectile.ProjectileController;
import processing.core.PGraphics;

import java.awt.*;

public class StarshipController extends GameController {
    public StarshipController(Vector2 position) {
        super(new Starship(position), new StarshipView());
    }

    public void moveForward() {
        Starship starship = (Starship) getGameObject();
        starship.moveForward();
    }

    public void moveBackwards() {
        Starship starship = (Starship) getGameObject();
        starship.moveBackwards();
    }

    public void rotateLeft() {
        Starship starship = (Starship) getGameObject();
        starship.rotateLeft();
    }

    public void rotateRight() {
        Starship starship = (Starship) getGameObject();
        starship.rotateRight();
    }

    public ProjectileController shoot() {
        Starship starship = (Starship) getGameObject();
        return starship.shoot(starship.getStarshipWeapon());
    }

    public int getLives() {
        Starship starship = (Starship) getGameObject();
        return starship.getLives();
    }

    public int getScore() {
        Starship starship = (Starship) getGameObject();
        return starship.getScore();
    }
}
