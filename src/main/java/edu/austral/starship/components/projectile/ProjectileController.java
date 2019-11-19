package edu.austral.starship.components.projectile;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.components._common.GameController;
import processing.core.PGraphics;

public class ProjectileController extends GameController {
    public ProjectileController(Projectile projectile) {
        super(projectile, new ProjectileView());
    }

    @Override
    public void render(PGraphics graphics) {
        Vector2 position = getGameObject().getPosition();
        if(position.x > 360 || position.x < -360 || position.y > 360 || position.y < -360) {
            getGameObject().destroy();
        } else {
            super.render(graphics);
        }
    }
}
