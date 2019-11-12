package edu.austral.starship.base.framework;

import processing.core.PGraphics;

public abstract class GameView {
    public abstract void render(PGraphics graphics, GameObject gameObject);
}
