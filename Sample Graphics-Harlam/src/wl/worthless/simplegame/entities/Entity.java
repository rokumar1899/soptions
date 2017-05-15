package wl.worthless.simplegame.entities;

import java.awt.*;
import wl.worthless.simplegame.*;

public abstract class Entity
{
	protected Handler handler;
    protected float xPoint, yPoint;
    protected int width, height;
    protected Rectangle bounds;
    private boolean alive;
    private boolean projectile;
    private boolean creature;
    private int point;
    
    public Entity(Handler ha, float x, float y, int w, int h)
    {
    	point = 0;
    	handler = ha;
        xPoint = x;
        yPoint = y;
        width = w;
        height = h;
        alive = true;
        projectile = false;
        setCreature(false);
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public boolean checkEntityCollisions(float xOffset, float yOffset)
    {
    	for(Entity e : handler.getWorld().getEntityManager().getEntities())
    	{
    		if(e.equals(this))
    		{
    			continue;//goes to next variable
    		}
    		if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
    	return new Rectangle((int)(xPoint + bounds.x + xOffset), (int)(yPoint + bounds.y + yOffset), bounds.width, bounds.height);
    }
    
    public float getX() {
		return xPoint;
	}

	public void setX(float xPoint) {
		this.xPoint = xPoint;
	}

	public float getY() {
		return yPoint;
	}

	public void setY(float yPoint) {
		this.yPoint = yPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public void setAlive(boolean a)
	{
		alive = a;
	}
	
	public boolean isProjectile()
	{
		return projectile;
	}
	
	public void setProjectile(boolean p)
	{
		projectile = p;
	}
	
	public void setPoint(int p)
	{
		point = p;
	}
	
	public int getPoint()
	{
		return point;
	}
	
	public abstract void tick();
    
    public abstract void render(Graphics g);

	public boolean getCreature() {
		return creature;
	}

	public void setCreature(boolean creature) {
		this.creature = creature;
	}
    
}