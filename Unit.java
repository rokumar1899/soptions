package com.mygdx.game;

import java.awt.*;

public abstract class Unit extends Entity
{
    protected float speed;// how fast unit moves
    protected float xMove, yMove;// how much it moves per turn
    protected int attackPower; // damage dealt
	
    public Unit(float x, float y, int w, int he, int h, int mh, int l, float s )
    {
        super(x, y, w, he, h, mh, l, true, true);
        speed = s;
        xMove = 0;
        yMove = 0;
        attackPower = 5;
    }
    
    //methods
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
    		int tx = (int)(xPoint + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
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
    		int tx = (int)(xPoint + xMove + bounds.x) / Tile.TILEWIDTH;
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
    			if(health<=0)
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
    protected boolean collisionWithTile(int x, int y) // check if outside the map or not
    {
    	return handler.getWorld().getTile(x, y).isSolid();
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
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}    
}
	 
	
	


