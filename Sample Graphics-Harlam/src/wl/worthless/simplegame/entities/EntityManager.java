package wl.worthless.simplegame.entities;

import wl.worthless.simplegame.*;
import wl.worthless.simplegame.entities.creatures.*;
import wl.worthless.simplegame.states.GameState;

import java.awt.*;
import java.util.*;

public class EntityManager 
{
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>()
			{
				public int compare(Entity a, Entity b)
				{
					if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
						return -1;
					else
					{
						return 1;
					}
				}
			};
			
	private long timer;
	private long lastTime;
	private int numCreature;
			
	
	
	public EntityManager(Handler h, Player p)
	{
		handler = h;
		player = p;
		entities = new ArrayList<Entity>();
		addEntity(player);
		numCreature = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(player.shoot() != null && timer > player.getRof())
		{
			entities.add(player.shoot());
			timer = 0;
		}
		
		for(int i = 0; i < entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.tick();
			if(!e.isAlive())
			{
				entities.remove(i);
				
				if(e.getCreature())
				{
					((GameState) handler.getGame().gameState).addScore(e.getPoint());	
					player.addMoney(e.getPoint()/2);
					numCreature--;
				}	
			}
		}
		//entities.sort(renderSorter);
	}
	
	public void render(Graphics g)
	{
		for(Entity e : entities)
		{
			e.render(g);
		}
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
		if(e.getCreature())
		{
			numCreature++;
		}
	}
	
	
	//getters setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public int getNumCreature()
	{
		return numCreature;
	}
}
