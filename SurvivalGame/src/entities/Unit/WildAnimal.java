package src.entities.Unit;

import java.awt.Graphics;
import src.gfx.*;
import src.Handler;
import java.awt.*;

public class WildAnimal extends Unit
{
	private Animation animal;
	private static final int DEFAULT_WIDTH = 64;
	private static final int DEFAULT_HEIGHT = 55;
	 
    public WildAnimal(Handler han, float x, float y, int h, int mh, int l, int s, int d)
    {
        super(han, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, h, mh, l, s, d);
        
        
        //Animations
        //animal = new Animation(500, Assets.animal_move );
    }

    // render and tick methods
    public void tick()
    {
    	animal.tick();
    	if(animal.mTimer())
    	{
    		getInput();
    	}	
    	move();
    	if(this.getHealth() <= 0)
    	{
    		setAlive(false);
    	}
    }
    public void render(Graphics g)
    {
        g.drawImage(animal.getCurrentFrame(), (int) (getXloc() - handler.getGameCamera().getxOffset()), (int) (getYloc() - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
    //other methods
    private void getInput()
    {
    	xMove = (int)(Math.random()*10-5);
    	yMove = (int)(Math.random()*10-5);
    }

    
    //getters and setters
   
}

