package main.states;

import main.Game;

import java.awt.*;

/**
 * Created by raven on 9/5/2015.
 */
public abstract class State {
    private static State currentState = null;


    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }



















    //userless
    public abstract void tick();

    public abstract void render(Graphics g);
    protected Game game;
    public State(Game game){
        this.game = game;
    }

}
