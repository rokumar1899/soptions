package sOption.states;

import sOption.worlds.*;
import java.awt.*;
import sOption.Connector;

public class GameState extends State
{
	private World world;
	
	public GameState(Connector c)
	{
		super(c);
		world = new World(connector);
	}

	@Override
	public void tick() 
	{
		// TODO Auto-generated method stub
		world.tick();
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		world.render(g);
	}
}
