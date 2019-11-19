package edu.austral.starship.components._common;

import processing.core.PGraphics;
import processing.core.PImage;

import static processing.core.PApplet.radians;
import static processing.core.PConstants.CENTER;

public abstract class GameView {
    private PImage image;

    public void render(PGraphics graphics,
                       float x,
                       float y,
                       float height,
                       float width,
                       float angle) {
        graphics.pushMatrix();
        graphics.imageMode(CENTER);
        graphics.translate(x + width / 2, y + height / 2);
        graphics.rotate(angle + radians(-90f));
        graphics.image(getImage(), 0, 0, width, height);
        graphics.popMatrix();
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }
}
