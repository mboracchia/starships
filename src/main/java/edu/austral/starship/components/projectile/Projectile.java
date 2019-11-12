package edu.austral.starship.components.projectile;

import edu.austral.starship.base.framework.GameObject;
import edu.austral.starship.base.interfaces.Visitor;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

public class Projectile extends GameObject {


    public Projectile(Vector2 position, Shape collider) {
        super(position, collider);
        setVisitor(new ProjectileVisitor());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void damage() {
        destroy();
    }
}
