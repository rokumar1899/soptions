package wl.worthless.simplegame.entities.projectiles;

import java.awt.Graphics;

import  wl.worthless.simplegame.*;
import wl.worthless.simplegame.gfx.*;


public class Bullet extends Projectile
{
	private Animation bullet;
	private String direction;
	
	public Bullet(Handler han, float x, float y, String d)
	{
		super(han, x, y, Projectile.DEFAULT_PROJECTILE_WIDTH, Projectile.DEFAULT_PROJECTILE_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = DEFAULT_PROJECTILE_WIDTH;
		bounds.height = DEFAULT_PROJECTILE_HEIGHT;
		direction = d;
		if(d.equals("E"))
		{
			bullet = new Animation(1000, Assets.bulletR_move, 300);
		}
		else if(d.equals("N"))
		{
			bullet = new Animation(1000, Assets.bulletU_move, 300);
		}
		else if(d.equals("W"))
		{
			bullet = new Animation(1000, Assets.bulletL_move, 300);
		}
		else
		{
			bullet = new Animation(1000, Assets.bulletD_move, 300);
		}
		getDirection();
	}
	
	
	@Override
	public void tick() 
	{
		bullet.tick();
		move();
		if(isHit())
		{
			setAlive(false);
		}
	}
	
	private boolean isHit()
	{
		float tx = xPoint;
		float ty = yPoint;
		moveX();
		moveY();
		float ax = xPoint;
		float ay = yPoint;
		
		if(tx == ax && ty == ay)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void getDirection()
	{
		xMove = 0;
		yMove = 0;
		
		if(direction.equals("N"))
		{
			yMove = -speed;
		}
		else if(direction.equals("S"))
		{
			yMove = speed;
		}
		else if(direction.equals("E"))
		{
			xMove = speed;
		}
		else
		{
			xMove = -speed;
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(bullet.getCurrentFrame(), (int)(xPoint - handler.getGameCamera().getxOffset()), (int) (yPoint - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}
