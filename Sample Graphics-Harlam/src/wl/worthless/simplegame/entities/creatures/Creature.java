package wl.worthless.simplegame.entities.creatures;

import wl.worthless.simplegame.entities.Entity;
import wl.worthless.simplegame.tiles.Tile;

import java.awt.*;
import wl.worthless.simplegame.*;

public abstract class Creature extends Entity
{
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
	public static final int DEFAULT_HEALTH = 5;
    public static final float DEFAULT_SPEED = 7.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
    public Creature(Handler han, float x, float y, int w, int h)
    {
        super(han, x, y, w, h);
        super.setCreature(true);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
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
    	if(xMove > 0)//Moving right
    	{
    		int tx = (int)(xPoint+xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
    		if(!collisionWithTile(tx, (int)(yPoint + bounds.y) / Tile.TILEHEIGHT) && 
    			!collisionWithTile(tx, (int)(yPoint + bounds.y + bounds.height)/ Tile.TILEHEIGHT))
    		{
    			xPoint += xMove;
    		}
    		else
    		{
    			xPoint = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
    		}
    	}
    	else if(xMove < 0)//Moving Left
    	{
    		int tx = (int)(xPoint+xMove + bounds.x) / Tile.TILEWIDTH;
    		if(!collisionWithTile(tx, (int)(yPoint + bounds.y) / Tile.TILEHEIGHT) && 
    			!collisionWithTile(tx, (int)(yPoint + bounds.y + bounds.height)/ Tile.TILEHEIGHT))
    		{
    			xPoint += xMove;
    		}
    		else
    		{
    			xPoint = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
    		}
    	}
    }
    
    public void moveY()
    {
    	if(yMove < 0)//going up
    	{
    		int ty = (int)(yPoint + yMove + bounds.y) / Tile.TILEHEIGHT;
    		
    		if(!collisionWithTile((int) (xPoint + bounds.x) / Tile.TILEWIDTH, ty) &&
    				!collisionWithTile((int) (xPoint + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
    		{
    			yPoint += yMove;
    		}
    		else
    		{
    			yPoint = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
    		}
    	}
    	else if(yMove > 0)// going down
    	{
    		int ty = (int)(yPoint + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
    		
    		if(!collisionWithTile((int) (xPoint + bounds.x) / Tile.TILEWIDTH, ty) &&
    				!collisionWithTile((int) (xPoint + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
    		{
    			yPoint += yMove;
    		}
    		else
    		{
    			yPoint = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
    		}
    	}
    }
    
    public boolean checkEntityCollisions(float xOffset, float yOffset)
    {
    	for(Entity e : handler.getWorld().getEntityManager().getEntities())
    	{
    		if(e.equals(this))
    		{
    			continue;//goes to next variable
    		}
    		if(e.isProjectile() && e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
    		{
    			health--;
    			e.setAlive(false);
    			return false;
    		}
    		if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
    	return handler.getWorld().getTile(x, y).isSolid();
    }
    
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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}