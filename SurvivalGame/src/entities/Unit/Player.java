package src.entities.Unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import src.Handler;
import src.gfx.*;

import src.items.Item;


public class Player extends Unit
{
	private Animation animDown, animUp, animRight, animLeft;
	private int mentalHealth, thirst, hunger;
	private ArrayList<Item> inventory;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 70;
	
    public Player(Handler han, float x, float y, int health, int maxHealth, float speed)
    {
        super(han, x, y, WIDTH, HEIGHT, health, maxHealth, 1, speed);
          
        //Animations
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        
       setMentalHealth(100);
       setThirst(100); 
       setHunger(100);
    }

    public void tick()
    {
    	animDown.tick();
    	animUp.tick();
    	animLeft.tick();
    	animRight.tick();
    	
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
     public void render(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int) (getXloc() - handler.getGameCamera().getxOffset()), (int) (getYloc() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
    }
    
      private void getInput()
    {
    	xMove = 0;
    	yMove = 0;
    	
    	if(handler.getKeyManager().getUP())
    	{
    		yMove = -speed;
    	}
    	if(handler.getKeyManager().getDOWN())
    	{
    		yMove = speed;
    	}
    	if(handler.getKeyManager().getLEFT())
    	{
    		xMove = -speed;
    	}
    	if(handler.getKeyManager().getRIGHT())
    	{
    		xMove = speed;
    	}
    }
      /*
    public Entity shoot()
    {
    	Entity b;
    	if(handler.getKeyManager().getUp())
    	{ 
    		b = new Bullet(handler, getX() + (width/2), getY() + (height/2), "N");
    		return b;
    	}
    	else if(handler.getKeyManager().getDown())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + height+10, "S");
    		return b;
    	}
    	else if(handler.getKeyManager().getLeft())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + (height/2), "W");
    		return b;
    	}
    	else if(handler.getKeyManager().getRight())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + (height/2), "E");
    		return b;
    	}
    	else
    	{
    		return null;
    	}
    	
    	
    	 * public void attack()
    	 * if(handler.getKeyManager().getX() && entity next to you && weapon!=bow)
    	 * {
    	 * 		that entity.health() -= this.weaponAttack;
    	 * }
    	 * 
    	 * public void interact
    	 * {
    	 * 		if(item next to you )
    	 * 			inventory.add(item);
    	 * 		else
    	 * 			
    	 * }
    	 * }
    	 * 	
    	 */
    
    
    private BufferedImage getCurrentAnimationFrame()
    {
    	if(xMove < 0)//moving left
    	{
    		return animLeft.getCurrentFrame();
    	}
    	else if(xMove > 0)
    	{
    		return animRight.getCurrentFrame();
    	}
    	else if(yMove < 0)
    	{
    		return animUp.getCurrentFrame();
    	}
    	else
    	{
    		return animDown.getCurrentFrame();
    	}
    }
    
    //getters and setters
	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getMentalHealth() {
		return mentalHealth;
	}

	public void setMentalHealth(int mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
}
	 
	



