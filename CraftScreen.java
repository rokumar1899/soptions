package sOption.gfx;

import sOption.Connector;
import sOption.items.*;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CraftScreen 
{
	protected BufferedImage screen;
	private Connector connector;
	protected ArrayList<Item> items;
	
	private int select;
	
	public CraftScreen(Connector c) 
	{
		connector = c;
		screen = Assets.craft;
		items.add(new Axe(c));
		items.add(new LArmor(c));
		items.add(new WArmor(c));
		items.add(new Arrow(c));
		items.add(new Bow(c));
		items.add(new Sword(c));
		items.add(new Chest(c));
		items.add(new CookedMeat(c));
		items.add(new SafeSpace(c));
		/*
		 * 	axe, larmor, warmor, arrow, bow, sword, chest, cooked meat, safeplace.
		 */
	}
	
	public void tick()
	{
		//access key manager up and down to increase and decrease the "select" variable
		if(connector.getKeyManager().getUP())
		{
			select++;
		}
		else if(connector.getKeyManager().getDOWN())
		{
			select--;
		}
		
		if(connector.getKeyManager().getENTER() && items.get(select).checkResources())
		{
			connector.getWorld().getEntityManager().getPlayer().getInventory().add(items.get(select));
		}
	}
	public void render(Graphics g)
	{
		g.drawImage(screen, 500, 300, 920, 480);
		for(int i = 0; i < items.size(); i++)
		{
			g.drawImage(items.get(i).getImage(),  600, 580, , , null)
		}
	}

	public BufferedImage getScreen() {
		return screen;
	}

	public void setScreen(BufferedImage screen) {
		this.screen = screen;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	

}
