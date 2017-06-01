package sOption.worlds;

import java.awt.Graphics;

import sOption.Connector;
import sOption.entities.*;
import sOption.entities.unit.*;
import sOption.items.ItemManager;

public class World 
{
	private Connector connector;
	private int width, height;
	
	private EntityManager entityManager;
	private Region region;
	private ItemManager itemManager;
	
	public World(Connector connector)
	{
		this.connector = connector;
		connector.setWorld(this);
		entityManager = new EntityManager(connector, new Player(connector, 2074, 1590, 100));
		itemManager = new ItemManager(connector);
		
		region = new Beach(connector);
		
		entityManager.addEntity(new Rabbit(connector, 4800, 4800));
	}
	
	public void tick()
	{
		region.tick();
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		Region.getRegion().render(g);
		//itemManager.render(g);
		entityManager.render(g);
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	public Connector getConnector()
	{
		return connector;
	}
	
	public Region getRegion()
	{
		return region;
	}
	
	public void setConnector(Connector connector)
	{
		this.connector = connector;
	}
	
	public ItemManager getItemManager()
	{
		return itemManager;
	}
	
	public void setItemManager(ItemManager itemManager)
	{
		this.itemManager = itemManager;
	}
}
