package src.entities.Unit;

import src.Handler;
import src.tiles.*;
import src.entities.Entity;
import java.awt.*;

public abstract class Unit extends Entity
{
    protected float speed;// how fast unit moves
    protected float xMove, yMove;// how much it moves per turn
    protected int attackPower; // damage dealt
	
    public Unit(Handler han, float x, float y, int w, int he, int h, int mh, int l, float s )
    {
        super(han, x, y, w, he, h, mh, l, true, true);
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
    		int tx = (int)(getXloc() + xMove + boundary.getX() + width) / Tile.TILEWIDTH;
    		if(!collisionWithTile(tx, (int)(yloc + boundary.getY()) / Tile.TILEHEIGHT) && 
    			!collisionWithTile(tx, (int)(yloc + boundary.getY() + height)/ Tile.TILEHEIGHT))
    		{
    			xloc += xMove;
    		}
    		else
    		{
    			xloc = (float)(tx * Tile.TILEWIDTH - boundary.getX() - width - 1);
    		}
    	}
    	else if(xMove < 0)//Moving Left
    	{
    		int tx = (int)(xloc + xMove + boundary.getX()) / Tile.TILEWIDTH;
    		if(!collisionWithTile(tx, (int)(yloc + boundary.getY()) / Tile.TILEHEIGHT) && 
    			!collisionWithTile(tx, (int)(yloc + boundary.getY() + height)/ Tile.TILEHEIGHT))
    		{
    			xloc += xMove;
    		}
    		else
    		{
    			xloc = (float)(tx * Tile.TILEWIDTH + Tile.TILEWIDTH - boundary.getX());
    		}
    	}
    }
    
    public void moveY()
    {
    	if(yMove < 0)//going up
    	{
    		int ty = (int)(yloc + yMove + boundary.getY()) / Tile.TILEHEIGHT;
    		
    		if(!collisionWithTile((int) (xloc + boundary.getX()) / Tile.TILEWIDTH, ty) &&
    				!collisionWithTile((int) (xloc + boundary.getX() + width) / Tile.TILEWIDTH, ty))
    		{
    			yloc += yMove;
    		}
    		else
    		{
    			yloc = (float)(ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - boundary.getY());
    		}
    	}
    	else if(yMove > 0)// going down
    	{
    		int ty = (int)(yloc + yMove + boundary.getY() + height) / Tile.TILEHEIGHT;
    		
    		if(!collisionWithTile((int) (xloc + boundary.getX()) / Tile.TILEWIDTH, ty) &&
    				!collisionWithTile((int) (xloc + boundary.getX() + width) / Tile.TILEWIDTH, ty))
    		{
    			yloc += yMove;
    		}
    		else
    		{
    			yloc = (float)(ty * Tile.TILEHEIGHT - boundary.getY() - height - 1);
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
    		if(e.isWeapon() && e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
    		{
    			health-= e.damage();
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
    
    /*
    public Tool shoot()
    {
    	Tool b = new Arrow// param(handler, xloc, yloc, xspeed, yspeed, width, height, damage)(handler, getX() + (width/2), getY() + (height/2), "N");
    	return b;
    }
    	
    		
    public void attack()
    	if(handler.getKeyManager().getX() && entity next to you && weapon!=bow)
    	{
    	  		that entity.health() -= this.weaponAttack;
    	}
    */
    
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
	 
	
	


