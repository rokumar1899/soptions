import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Enemy
{
	private Rectangle E = null;
	private int ChangeXEN;
	private int ChangeYEN;
	private int locXEN;
	private int locYEN;
	private int health;
	public Enemy(int x, int y)
	{
		ChangeXEN = 1;
		ChangeYEN = 1;
		locXEN=x;
		locYEN=y;
		E = new Rectangle(locXEN, locYEN, 10, 10);
		E.setBounds(locXEN, locYEN, 10, 10);
	}
	public Rectangle getEnemy()
	{
		return E;
	}
	public Rectangle getEnemyBounds()
	{
		return E.getBounds();
	}
	public void removeHealth(int x)
	{
		health -= x;
	}
	public int getHealth()
	{
		return health;
	}
	public void changeX(int x)
	{
		ChangeXEN = x;
	}
	public void changeY(int y)
	{
		ChangeYEN = y;
	}
	public int getChangeXEN()
	{
		return ChangeXEN;
	}
	public int getChangeYEN()
	{
		return ChangeYEN;
	}
	public void moveEnemy()
	{
		E= new Rectangle((int)E.getX()+ChangeXEN, (int)E.getY()+ChangeYEN, (int)E.getWidth(), (int)E.getHeight());
	}

	public void directionChange(int C)
	{
		int D = (int)(Math.random()*100+1);
		if(D<C+1)
		{
			ChangeXEN = ChangeXEN*-1;
		}
		else if(D>=C+1)
		{
			ChangeXEN = ChangeXEN;
		}
		D = (int)(Math.random()*100+1);
		if(D<C+1)
		{
			ChangeYEN = ChangeYEN*-1;
		}
		else if(D>=C+1)
		{
			ChangeYEN = ChangeYEN;
		}

	}
	public void bounce()
	{
		if((int)E.getX()<=10||(int)E.getX()>=489)
		{
			ChangeXEN=-1*ChangeXEN;
		}
		if((int)E.getY()<=10||(int)E.getY()>=489)
		{
			ChangeYEN=-1*ChangeYEN;
		}
	}

}
