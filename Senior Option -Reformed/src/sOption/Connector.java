package sOption;

import sOption.gfx.*;
import sOption.input.*;
import sOption.worlds.*;

public class Connector 
{
	private Game game;
	private World world;
	
	public Connector(Game game)
	{
		this.game = game;
	}
	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}

	public Game getGame() 
	{
		return game;
	}

	public void setGame(Game game) 
	{
		this.game = game;
	}

	public World getWorld() 
	{
		return world;
	}

	public void setWorld(World world) 
	{
		this.world = world;
	}
}
