package src.states;

import java.awt.Graphics;
import java.awt.*;

public class MenuState extends State
{
	private String instruction;
	
    public MenuState(Handler h)
    {
        super(h);
        instruction = "Press \"T\" to Start";
    }
    
    public void tick()
    {
    	if(handler.getKeyManager().getT())
    	{
    		State.setState(handler.getGame().gameState);
    	}
    }
    
    public boolean gameOver()
    {
    	return false;
    }
    
    public void render(Graphics g)
    {
    	g.drawString(instruction, handler.getWidth() /2, handler.getHeight() /2 );
        g.setColor(Color.GREEN);
        g.fillOval(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
    }
}