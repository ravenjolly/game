package main.Entity;

import java.awt.*;

/**
 * Created by raven on 9/5/2015.
 */
public abstract class Entity {

    protected float x,y;

    public Entity(float x, float y){
        this.x = x;
        this.y = y;


    }
    public abstract void tick();
    public abstract void render(Graphics g);


}
