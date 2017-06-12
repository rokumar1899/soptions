package sOption.entities;

import java.awt.event.KeyEvent;

import sOption.Connector;
import sOption.gfx.Animation;
import sOption.items.Item;

public class Tree extends Structure 
{
	public Animation tree_left, tree_right;
	
	public Tree(Connector c, float x, float y, int w, int h, int hp, String n) 
	{
		super(c, x, y, w, h, 20, "Tree");
	}
	
	public void generateDrops() 
	{
		this.getDrops().add(Wood);
		this.getDrops().add(Wood);
		this.getDrops().add(Leaves);
	}
	
	public void interact()
	{
		if(this.getBoundary().intersects(connector.getWorld().getEntityManager().getPlayer().getBoundary()) && this.getHealth()==0);
		{
			for(Item x: this.getDrops())
				connector.getWorld().getEntityManager().getPlayer().getDrops().add(x);
		}
	}

}
