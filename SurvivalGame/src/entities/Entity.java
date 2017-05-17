package src.entities;

import java.awt.Rectangle;

public abstract class Entity {
	private float xloc, yloc;// position of object
	private int width, height;// how long and tall
	private int health;// current health
	private int maxHealth;// max amount of health
	private Rectangle boundary; // change to texture later if necessary
	private int hostility;// how friendly or hostile(0=friendly, 1=attack if you attack, 2=hostile)
	private int level;// how difficult
	private boolean alive;/// whether or not we are alive
	private boolean canAttack;// whether or not it can attack
	protected Handler handler;
	
	public Entity(float x, float y, int w, int he, int h, int mh, int l, boolean a, boolean c)
	{
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
	public boolean checkEntityCollision(float xOffset, float yOffset)
	  {
	  		for(Entity e: handler.getWorld().getEntityUpdater().getEntities()))
	  		{
	  			if(e.equals(this))// skip itself
	  			{
		 			continue;
	  			}
	  			if(!e.isProjectile() && e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))))
	  			{
	  				if(!team.equals(accessor.getPlayerInterface().getColor()) && !e.isBuilding()))
	  					return true;
	 			}	
	 		}
	 		return false;
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


