package main.Entity.creatures;

import main.Entity.Entity;

/**
 * Created by raven on 9/5/2015.
 */
public abstract class Creature extends Entity {

    protected int health;
    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
}
