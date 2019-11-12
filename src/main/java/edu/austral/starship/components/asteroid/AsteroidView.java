package edu.austral.starship.components.asteroid;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.framework.GameView;
import processing.core.PGraphics;

public class AsteroidView extends GameView {
    @Override
    public void render(PGraphics graphics, GameObject gameObject) {
        graphics.fill(40);
        graphics.rect(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getShape().getBounds().height, gameObject.getShape().getBounds().width);
    }
}