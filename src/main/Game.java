package main;

import main.states.GameState;
import main.states.MenuState;
import main.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by raven on 8/17/2015.
 */
public class Game implements Runnable{

    private Window display;
    public int width, height;
    public String title;
    private Boolean running = false;
    private Thread thread;
    public static int fps = 60;



    private BufferStrategy bs;
    private Graphics g;

    //states
    private State gameState;
    private State menuState;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init(){
        display = new Window(title, width, height);
        Assets.init();
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);

    }
//TODO finish episode 14 https://www.youtube.com/watch?v=AhNJCfn_Odc&index=14&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ


    private void tick(){
    if(State.getState()!= null)
        State.getState().tick();

    }

    private void render(){
        bs=display.getCanvas().getBufferStrategy();

        if (bs== null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        //draw here
        if(State.getState()!= null)
            State.getState().render(g);

        //end drawing
        bs.show();
        g.dispose();
    }
    public void run(){
        init();


        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta>=1) {
                tick();
                render();
                ticks ++;
                delta--;

            }
            /*
            //check for thing
            if(timer>=1000000000){
                System.out.println("ticks and frames:"+ticks);
                ticks = 0;
                timer = 0;
            }*/

            }

        stop();
    }






    public synchronized void start(){
        if(running)
            return;
            running = true;
        thread = new Thread(this);
        thread.start();
    }




    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
