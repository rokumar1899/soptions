package sOption.entities;

import java.awt.event.KeyEvent;
import sOption.Connector;
import sOption.gfx.Animation;
import sOption.items.Item;

public class Rock extends Structure {

	public Animation rock;
	
	public Rock(Connector c, float x, float y, int w, int h, int hp, String n)
	{
		super(c, x, y, w, h, 0, "Rock");
	}
	
	public void generateDrops() 
	{
		this.getDrops().add(Stone);
		this.getDrops().add(Stone);
		this.getDrops().add(Stone);
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
