package main;

import java.awt.image.BufferedImage;

/**
 * Created by raven on 8/17/2015.
 */
public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage dirt, grass;

    public static void init(){
    SpriteSheet terrain = new SpriteSheet(ImageLoader.loadImage("/textures/tilesheet.png"));
        dirt = terrain.crop(0,0,width, height);
        grass = terrain.crop(width, 0, width, height);





    }



}
