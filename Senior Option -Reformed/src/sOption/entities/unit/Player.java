package sOption.entities.unit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import sOption.Connector;
import sOption.gfx.*;
import sOption.items.Item;

public class Player extends Unit
{
	private Animation animDown, animUp, animRight, animLeft;
	private int mentalHealth, thirst, hunger;
	private ArrayList<Item> inventory;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 100;
	
	public Player(Connector c, float x, float y, int health)
	{
		super(c, x, y, WIDTH, HEIGHT, 100, 1, 7);
		this.alive = true;
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
	}
	
	public void tick()
	{
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		move();
		connector.getGameCamera().centerOnEntity(this);
	}
	
	public void render(Graphics g)
	{
		g.drawImage(getCurrentAnimationFrame(), (int) (getXloc() - connector.getGameCamera().getxOffset()), (int) (getYloc() - connector.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
		System.out.println("xloc = "+xloc);
		System.out.println("yloc = "+yloc);
	}
	
	private void getInput()
	{
		xMove = 0;
    	yMove = 0;
    	
    	if(connector.getKeyManager().getUP())
    	{
    		yMove = -speed;
    	}
    	if(connector.getKeyManager().getDOWN())
    	{
    		yMove = speed;
    	}
    	if(connector.getKeyManager().getLEFT())
    	{
    		xMove = -speed;
    	}
    	if(connector.getKeyManager().getRIGHT())
    	{
    		xMove = speed;
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
