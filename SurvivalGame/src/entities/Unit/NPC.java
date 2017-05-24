package src.entities.Unit;

import java.awt.Graphics;

import src.Handler;
import src.gfx.Animation;
import src.gfx.Assets;

public class NPC extends Unit
{	
	private Animation NPCdown, NPCup, NPCleft, NPCright;
	private static final int DEFAULT_WIDTH = 60;
	private static final int DEFAULT_HEIGHT = 60;
	private static final int MAX_HEALTH = 100;
	private static final float DEFAULT_SPEED = 5.0f;
	
	public NPC(Handler han, float x, float y, int h)
	{
		super(han, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, h, MAX_HEALTH, 10, DEFAULT_SPEED, 5);
		NPCdown = new Animation(500, Assets.NPC_down);
		NPCup = new Animation(500, Assets.NPC_up);
		NPCleft = new Animation(500, Assets.NPC_left);
		NPCright = new Animation(500, Assets.NPC_right);
	}

	@Override
	public void tick()
	{
		NPC.tick();
    	if(NPC.mTimer())
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
		int x = (int) (Math.random()*2);
		if(x==0)
		{
			xMove = (int)(Math.random()*2);
			
		}
		else
			xMove = -1*(int)(Math.random()*2);
    }

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(NPC.getCurrentFrame(), (int) (getXloc() - handler.getGameCamera().getxOffset()), (int) (getYloc() - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
