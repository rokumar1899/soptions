package src.entities.Unit;

import java.awt.Graphics;
import java.awt.*;

public class WildAnimal extends Unit
{
	private Animation animal;
	private static final int DEFAULT_WIDTH = 64;
	private static final int DEFAULT_HEIGHT = 55;
	 
    public WildAnimal(float x, float y, int h, int mh, int l, int s)
    {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, h, mh, l, s );
    
        //These represent the part of the body
        
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
        setPoint(30);
        //Animations
        animal = new Animation(500, Assets.germ_move, 500);
    }

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
    
    private void getInput()
    {
    	xMove = (int)(Math.random()*10-5);
    	yMove = (int)(Math.random()*10-5);
    }

    public void render(Graphics g)
    {
        g.drawImage(animal.getCurrentFrame(), (int) (xPoint - handler.getGameCamera().getxOffset()), (int) (yPoint - handler.getGameCamera().getyOffset()), width, height, null);
    }
   
}

