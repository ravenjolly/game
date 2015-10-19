package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by raven on 8/17/2015.
 */
public class Window {
    private JFrame frame;
    private String title;
    private int width, height;
    private Canvas canvas;


    public Window(String title, int width, int height){

        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();

    }

private void createDisplay(){
    frame = new JFrame(title);
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);



    Dimension dim = new Dimension(width, height);
    canvas = new Canvas();
    canvas.setPreferredSize(dim);
    canvas.setMaximumSize(dim);
    canvas.setMinimumSize(dim);

    frame.add(canvas);
    frame.pack();
}


public Canvas getCanvas(){
    return canvas;
}


}
