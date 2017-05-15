package wl.worthless.simplegame.display;

import javax.swing.*;
import java.awt.*;

public class Display
{
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    public Display(String t, int w, int h)
    {
        title = t;
        width = w;
        height = h;
        
        createDisplay();
    }
    
    private void createDisplay()
    {
        frame = new JFrame(title);
        frame.setSize(width, height);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure your program shuts off when u exit
        
        frame.setResizable(false); //makes whether you can change size of window or not
        
        frame.setLocationRelativeTo(null); // makes window appear at the center;
        
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false); //This will make JFrame to focus on itself instead of the draw
        
        frame.add(canvas);
        frame.pack();
    }
    
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
}