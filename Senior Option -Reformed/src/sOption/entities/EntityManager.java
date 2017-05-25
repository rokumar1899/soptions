package sOption.entities;

import java.awt.Graphics;
import java.util.*;

import sOption.Connector;
import sOption.entities.*;
import sOption.entities.unit.*;

public class EntityManager 
{
	private Connector connector;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getYloc() + a.getHeight() < b.getYloc() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Connector connector, Player player)
	{
		this.connector = connector;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			if(!e.isAlive())
				it.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public Connector getConnector()
	{
		return connector;
	}
	
	public void setConnector(Connector connector)
	{
		this.connector = connector;
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
}
