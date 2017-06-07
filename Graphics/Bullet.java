import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Bullet
{
	private Rectangle O = null;
	private int locXB;
	private int locYB;
	private int changeXB;
	private int changeYB;
	private int startY;
	private int startX;
	private int G;

	public Bullet(int x, int y, int g)
	{
		changeXB = 1;
		changeYB = 1;
		locXB=x;
		locYB=y;
		startY=y;
		startX=x;
		G=g;
		O = new Rectangle(locXB, locYB, 10, 10);
		O.setBounds(locXB, locYB, 10, 10);
	}
	public int getG()
	{
		return G;
	}
	public Rectangle getBullet()
	{
		return O;
	}

	public Rectangle getBulletBounds()
	{
		return O.getBounds();
	}

	public int getChangeXB()
	{
		return changeXB;
	}

	public int getChangeYB()
	{
		return changeYB;
	}

	public void moveBulletR()
	{
		changeXB=3;
		O = new Rectangle((int)O.getX()+changeXB, (int)O.getY(), (int)O.getWidth(), (int)O.getHeight());
	}
	public void moveBulletL()
	{
		changeXB=3;
		O = new Rectangle((int)O.getX()-changeXB, (int)O.getY(), (int)O.getWidth(), (int)O.getHeight());
	}
	public void moveBulletU()
	{
		changeYB=3;
		O = new Rectangle((int)O.getX(), (int)O.getY()-changeYB, (int)O.getWidth(), (int)O.getHeight());
	}
	public void moveBulletD()
	{
		changeYB=3;
		O = new Rectangle((int)O.getX(), (int)O.getY()+changeYB, (int)O.getWidth(), (int)O.getHeight());
	}
	public boolean getDistance()
	{
		if(startX+200==(int)O.getX())
		{
			return true;
		}
		else if(startX-200==(int)O.getX())
		{
			return true;
		}
		else if(startY+200==(int)O.getY())
		{
			return true;
		}
		else if(startY-200==(int)O.getY())
		{
			return true;
		}
		return false;
	}
}