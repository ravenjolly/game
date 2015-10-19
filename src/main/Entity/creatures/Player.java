package main.Entity.creatures;

import main.Assets;

import java.awt.*;

/**
 * Created by raven on 9/5/2015.
 */
public class Player extends Creature {


    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    g.drawImage(Assets.grass, (int)x, (int)y, null);
    }

}
