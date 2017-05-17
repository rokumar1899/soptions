package com.mygdx.game;

import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;

import com.badlogic.gdx.graphics.g2d.Animation;

public class Player extends Unit
{
	private Animation animDown, animUp, animRight, animLeft;
	private int mentalHealth, thirst, hunger;
	private int currency;
	private ArrayList<Items> inventory;
	public static final int WIDTH = 64;
	public static final int HEIGHT = 70;
	
    public Player(float x, float y, int health, int maxHealth, float speed)
    {
        super(x, y, WIDTH, HEIGHT, health, maxHealth, 1, speed);
    
        //These represent the part of the body
        
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height = 19;
        
        //Animations
        animDown = new Animation(500, Assets.player_down, 300);
        animUp = new Animation(500, Assets.player_up, 300);
        animLeft = new Animation(500, Assets.player_left, 300);
        animRight = new Animation(500, Assets.player_right, 300);
        
       currency = 0;
       mentalHealth=100;
       thirst=100; 
       hunger=100;
    }

    public void tick()
    {
    	animDown.tick();
    	animUp.tick();
    	animLeft.tick();
    	animRight.tick();
    	
        getInput();
        move();
        //handler.getGameCamera().centerOnEntity(this);
    }
    
     public void render(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int) (xPoint - handler.getGameCamera().getxOffset()), (int) (yPoint - handler.getGameCamera().getyOffset()), width, height, null);
    }
    
      private void getInput()
    {
    	xMove = 0;
    	yMove = 0;
    	
    	if(handler.getKeyManager().getW())
    	{
    		yMove = -speed;
    	}
    	if(handler.getKeyManager().getS())
    	{
    		yMove = speed;
    	}
    	if(handler.getKeyManager().getA())
    	{
    		xMove = -speed;
    	}
    	if(handler.getKeyManager().getD())
    	{
    		xMove = speed;
    	}
    	if(handler.getMouseManager().isUpgradeRof() && money >= 100)
    	{
    		addRof(-50);
    		addMoney(-100);
    	}
    }
    
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
    }
    
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
    
    public long getRof()
    {
    	return rof;
    }
    
    public void addRof(long r)
    {
    	if(rof > 50)
    	rof += r;
    }
    
    public void setRof(long r)
    {
    	rof = r;
    }
    
    public void addMoney(int m)
    {
    	money += m;
    }
    
    public int getMoney()
    {
    	return money;
    }
}
	 
	


