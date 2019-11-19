package edu.austral.starship.components.starship;

import edu.austral.starship.components._common.GameView;
import processing.core.PGraphics;

import static processing.core.PApplet.radians;
import static processing.core.PConstants.CENTER;

public class StarshipView extends GameView {
    private static final String SPRITE_PATH = "src/main/java/edu/austral/starship/components/_assets/starship";

    @Override
    public void render(PGraphics graphics, float x, float y, float height, float width, float angle) {
        super.render(graphics, x, y, height, width, angle);
    }

    public static String getSpritePath() {
        return SPRITE_PATH;
    }
}
