package sOption.entities.unit;

import sOption.Connector;
import sOption.entities.*;
import java.awt.*;

public abstract class Unit extends Entity
{
	protected float speed;
	protected float xMove, yMove;
	protected int damage;
	
	public Unit(Connector c, float x, float y, int w, int h, int hp, int ho, float s)
	{
		super(c, x, y, w, h, hp, ho);
		speed = s;
		xMove = 0;
		yMove = 0;
		damage = 0;
	}
	
	public void move()
	{
		if(!checkEntityCollisions(xMove, 0f))
    	{
    		moveX();
    	}
    	if(!checkEntityCollisions(0f, yMove))
    	{
    		moveY();
    	}
	}
	
	public void moveX()
	{
		if(xMove > 0)//Moving Right
		{
			if(xloc < 10000 - width)
			{
				xloc += xMove;
			}
			else
			{
				xloc = 10000 - width;
			}
		}
		else if(xMove < 0)//Moving Left
		{
			if(xloc > width)
			{
				xloc += xMove;
			}
			else
			{
				xloc = width;
			}
		}
	}
	
	public void moveY()
	{
		if(yMove > 0) //Moving Down
		{
			if(yloc < 8000 - height)
			{
				yloc += yMove;
			}
			else
			{
				yloc = 8000 - height;
			}
		}
		else if(yMove < 0) //Moving up
		{
			if(yloc < height)
			{
				yloc += yMove;
			}
			else
			{
				yloc = height;
			}
		}
	}

	 // render and tick
    public abstract void tick();
    public abstract void render(Graphics g);
    
    // setters and getters
    public float getxMove() {
		return xMove;
    }
    
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	
	public float getyMove() {
		return yMove;
	}
	
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void addHealth(int h)
	{
		this.health += h;
	}
	
	public void subtractHealth(int h)
	{
		this.health -= h;
	}
	
	public float getSpeed() 
	{
		return speed;
	}
	
	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}
}
