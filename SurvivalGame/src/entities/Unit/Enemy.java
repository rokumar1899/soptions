package src.entities.Unit;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.gfx.*;
import java.util.ArrayList;
import java.util.Random;
import src.entities.*;
import src.Handler;
import src.gfx.*;

public class Enemy extends Unit 
{
	private Animation enemyUp, enemyDown, enemyLeft, enemyRight;
	private static final int DEFAULT_WIDTH = 64;
	private static final int DEFAULT_HEIGHT = 70;
	
	public Enemy(Handler han, float x, float y, int w, int he, int h, int mh, int l, float s)
	{
		super(han, x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, h, mh, l, s);
		super.attackPower = 15;
		
		//Animations
        enemyDown = new Animation(500, Assets.enemy_down);
        enemyUp = new Animation(500, Assets.enemy_up);
        enemyLeft = new Animation(500, Assets.enemy_left);
        enemyRight = new Animation(500, Assets.enemy_right);
	}

	//render and tick
	@Override
	public void tick() {
		moveEnemy();

	}
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (getXloc() - handler.getGameCamera().getxOffset()), (int) (getYloc() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}
	
	//methods
	public void moveEnemy()
	{
		if(Math.abs(handler.getWorld().getEntityManager().getPlayer().getXloc() - this.getXloc())>=50 && 
				Math.abs(handler.getWorld().getEntityManager().getPlayer().getYloc() - this.getYloc())>=50)// if the player is more than 50 spaces away, move at random
		{
			Random x = new Random();
			int a = (int)(Math.random()*2);
			if(a==0)
			{
				super.setxMove(x.nextInt(5+1+5)-5);
				super.move();
			}
			else
			{
				super.setyMove(x.nextInt(10+1+10)-10);
				super.move();
			}
		}
		else// if the player is within enemy range, enemy moves towards him
		{
			if(handler.getWorld().getEntityManager().getPlayer().getXloc() > this.getXloc())
				super.setxMove(10);
			else if(handler.getWorld().getEntityManager().getPlayer().getXloc() == this.getXloc())
				super.setxMove(0);
			else
				super.setxMove(-10);
			if(handler.getWorld().getEntityManager().getPlayer().getYloc() > this.getYloc())
				super.setyMove(10);
			else if(handler.getWorld().getEntityManager().getPlayer().getYloc() == this.getYloc())
				super.setyMove(0);
			else
				super.setyMove(-10);
			super.move();	
		}
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
