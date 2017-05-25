package sOption.items;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import sOption.Connector;

public class ItemManager {
	
	private Connector connector;
	private ArrayList<Item> items;
	
	public ItemManager(Connector connector){
		this.connector = connector;
		items = new ArrayList<Item>();
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item i = it.next();
			i.tick();
			if(i.isPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g){
		for(Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i){
		i.setConnector(connector);
		items.add(i);
	}
	
	// Getters and Setters

	public Connector getConnector() {
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

}