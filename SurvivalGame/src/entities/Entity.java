package src.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import src.Handler;

public abstract class Entity {
	protected float xloc, yloc;// position of object
	protected int width, height;// how long and tall
	protected int health;// current health
	protected int maxHealth;// max amount of health
	protected Rectangle boundary; // change to texture later if necessary
	protected int hostility;// how friendly or hostile(0=friendly, 1=attack if you attack, 2=hostile)
	protected int level;// how difficult
	protected boolean alive;/// whether or not we are alive
	protected boolean canAttack;// whether or not it can attack
	protected Handler handler;// keeps track of all actions
	
	public Entity(Handler han, float x, float y, int w, int he, int h, int mh, int l, boolean a, boolean c)
	{
		handler = han;
		setXloc(x);
		setYloc(y);
		width=w;
		height =he;
		setHealth(h);
		setMaxHealth(mh);
		setLevel(l);
		setAlive(a);
		setCanAttack(c);
		setBoundary(new Rectangle((int) x, (int) y, width, height));
	}
	
	//check if overlapping or hit boundary
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int) (xloc + boundary.getX() + xOffset), (int) (yloc + boundary.getY() + yOffset), width, height);
	}
	
	// render and tick
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//setters and getters
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
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
	public boolean getCanAttack() {
		return canAttack;
	}
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	public float getYloc() {
		return yloc;
	}
	public void setYloc(float yloc) {
		this.yloc = yloc;
	}
	public float getXloc() {
		return xloc;
	}
	public void setXloc(float xloc) {
		this.xloc = xloc;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public Rectangle getBoundary() {
		return boundary;
	}
	public void setBoundary(Rectangle boundary) {
		this.boundary = boundary;
	}
	public int getHostility() {
		return hostility;
	}
	public void setHostility(int hostility) {
		this.hostility = hostility;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}


