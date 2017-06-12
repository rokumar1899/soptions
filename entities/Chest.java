package sOption.entities;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import sOption.Connector;
import sOption.gfx.Animation;
import sOption.items.Item;

public class Chest extends Structure {

	public Animation chest;
	public final ArrayList<Item> treasure = new ArrayList<Item>();
	
	public Chest(Connector c, float x, float y, int w, int h, int hp, String n) 
	{
		super(c, x, y, w, h, 0, "Chest");
		treasure.add(Wood);
		treasure.add(Leaves);
		treasure.add(Stone);
		treasure.add(Sword);
		treasure.add(Arrows);
		treasure.add(Armor);
		treasure.add(Bow);
	}
	
	public void generateDrops() 
	{
		int x = (int)(Math.random() * treasure.size());
		this.getDrops().add(treasure.get(x));
	}
	
	public void interact()
	{
		if(this.getBoundary().intersects(connector.getWorld().getEntityManager().getPlayer().getBoundary()));
		{
			for(Item x: this.getDrops())
				connector.getWorld().getEntityManager().getPlayer().getDrops().add(x);
		}
	}

}
