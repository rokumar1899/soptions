package sOption.entities.unit;

import sOption.Connector;
import sOption.entities.*;
import sOption.gfx.Animation;
import sOption.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Goat extends Unit
{
	private Animation animDown, animUp, animRight, animLeft;
	
	public Goat(Connector c, float x, float y)
	{
		super(c, x, y, 50, 50, 70, 2, 5);
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
	}
	
	@Override
	public void tick()
	{
		xMove = (float)Math.random()*2*speed-speed;
		move();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (getXloc() - connector.getGameCamera().getxOffset()), (int) (getYloc() - connector.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove < 0) //moving left
		{
			return animLeft.getCurrentFrame();
		}
		else if(xMove > 0) //moving right
		{
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0) //moving up
		{
			return animUp.getCurrentFrame();
		}
		else
		{
			return animDown.getCurrentFrame();
		}
	}
}
