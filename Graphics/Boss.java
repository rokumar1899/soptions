import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Boss
{
	private Rectangle E = null;
	private int ChangeXEN;
	private int ChangeYEN;
	private int locXEN;
	private int locYEN;
	private int Health;
	public Boss()
	{
		Health = 150;
		ChangeXEN = 0;
		ChangeYEN = 0;
		locXEN=225;
		locYEN=225;
		E = new Rectangle(locXEN, locYEN, 50, 50);
		E.setBounds(locXEN, locYEN, 50, 50);
	}
	public Rectangle getBoss()
	{
		return E;
	}
	public Rectangle getBossBounds()
	{
		return E.getBounds();
	}
	public int getChangeBXEN()
	{
		return ChangeXEN;
	}
	public void changeBX(int x)
	{
		ChangeXEN=x;
	}
	public void changeBY(int x)
	{
		ChangeYEN=x;
	}
	public int getChangeBYEN()
	{
		return ChangeYEN;
	}
	public void moveBoss()
	{
		E= new Rectangle((int)E.getX()+ChangeXEN, (int)E.getY()+ChangeYEN, (int)E.getWidth(), (int)E.getHeight());
	}
	public void setBHealth(int x)
	{
		Health = x;
	}
	public void removeBHealth(int x)
	{
		Health= Health-x;
	}
	public int getBHealth()
	{
		return Health;
	}

	public void Bossbounce()
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