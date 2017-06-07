import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Level
{
	private int NumE;
	private ArrayList<Enemy> enemies;
	private int lvl;
	private int z=0;
	private int y=0;
	//DC must be less than or equal to 5
	public Level(int x)
	{
		lvl = x;
		NumE = x;
		enemies = new ArrayList<Enemy>();
	}
	public ArrayList<Enemy> createEnemies()
	{
		for(int x=0; x<NumE; x++)
		{
			z = (int)(Math.random()*479)+10;
			y = (int)(Math.random()*479)+10;
			Enemy A = new Enemy(z, y);
			enemies.add(A);
			z=0;
			y=0;
		}
		return enemies;
	}
	public void increaseLvl()
	{
		lvl++;
	}
	public int getLvl()
	{
		return lvl;
	}
}