package sOption.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import sOption.Connector;

public abstract class Entity 
{
	protected float xloc, yloc;
	protected int width, height;
	protected int health;
	protected int maxHealth;
	protected Rectangle boundary;
	protected int hostility;
	protected boolean alive;
	protected boolean canAttack;
	protected Connector connector;
	
	public Entity(Connector c, float x, float y, int w, int h, int hp, int ho)
	{
		connector = c;
		setXloc(x);
		setYloc(y);
		width = w;
		height = h;
		setHealth(hp);
		setMaxHealth(hp);
		setHostility(ho);
		setBoundary(new Rectangle((int)x, (int) y, width, height));
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		for(Entity e : connector.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
			{
				continue;
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
		return new Rectangle((int) (xloc + boundary.getX() + xOffset), (int)(yloc + boundary.getY() + yOffset));
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
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
