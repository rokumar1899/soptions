package sOption.entities;

import java.awt.Graphics;
import sOption.Connector;

public abstract class Structure extends Entity
{
	private String name;
	
	public Structure(Connector c, float x, float y, int w, int h, int hp, String n) 
	{
		super(c, x, y, w, h, hp, 0);
		setName(n);
	}

	@Override
	public void tick() 
	{}

	@Override
	public void render(Graphics g) 
	{}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void interact();

}
