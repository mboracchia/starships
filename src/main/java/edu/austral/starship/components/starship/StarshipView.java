package edu.austral.starship.components.starship;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.framework.GameView;
import processing.core.PGraphics;

public class StarshipView extends GameView {
    @Override
    public void render(PGraphics graphics, GameObject gameObject) {
        graphics.fill(60);
        graphics.rect(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getShape().getBounds().height, gameObject.getShape().getBounds().width);
    }
}
