package main.states;

import main.Assets;
import main.Entity.creatures.Player;
import main.Game;

import java.awt.*;

/**
 * Created by raven on 9/5/2015.
 */
public class GameState extends State {


    private Player player = new Player(100,100);

    public GameState(Game game){
    super(game);
    }



    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        player.render(g);



    }
}
