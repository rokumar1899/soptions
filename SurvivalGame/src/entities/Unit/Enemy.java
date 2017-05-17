package src.entities.Unit;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Enemy extends Unit 
{
	private Animation enemy;
	private static final int DEFAULT_WIDTH = 64;
	private static final int DEFAULT_HEIGHT = 70;
	
	public Enemy(float x, float y, int w, int he, int h, int mh, int l, float s)
	{
		super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, h, mh, l, s);
		super.attackPower = 15;
	}

	//render and tick
	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
	}
	
	//methods
	public void moveEnemy()
	{
		if(Math.abs(Player.getXloc - this.getXloc())>=50)
			// idk what to do here
		//Enemy= new Rectangle((int)Enemy.getX()+changeXPos, (int)Enemy.getY()+changeYPos, (int)E.getWidth(), (int)E.getHeight());
	}
	/*public void directionChange(int C)
	{
		int D = (int)(Math.random()*100+1);
		if(D<C+1)
			changeXPos = changeXPos*-1;
		D = (int)(Math.random()*100+1);
		if(D<C+1)
			changeYPos = changeYPos*-1;
	}
	public void bounce()
	{
		if((int)E.getX()<=10||(int)E.getX()>=489)
		{
			changeXPos = changeXPos*-1;
		}
		if((int)E.getY()<=10||(int)E.getY()>=489)
		{
			changeYPos = changeYPos*-1;
		}
	*/
	// getters and setters
	public static int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}
	public static int getDefaultHeight() {
		return DEFAULT_HEIGHT;
	}
}
