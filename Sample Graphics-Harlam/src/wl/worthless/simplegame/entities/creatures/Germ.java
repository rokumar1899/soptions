package wl.worthless.simplegame.entities.creatures;

import  wl.worthless.simplegame.*;
import wl.worthless.simplegame.gfx.*;

import java.awt.*;

public class Germ extends Creature
{
private Animation germM;
	
    public Germ(Handler h, float x, float y)
    {
        super(h, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    
        //These represent the part of the body
        
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
        setPoint(30);
        //Animations
        germM = new Animation(500, Assets.germ_move, 500);
    }

    public void tick()
    {
    	germM.tick();
    	if(germM.mTimer())
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
        g.drawImage(germM.getCurrentFrame(), (int) (xPoint - handler.getGameCamera().getxOffset()), (int) (yPoint - handler.getGameCamera().getyOffset()), width, height, null);
    }
   
}
