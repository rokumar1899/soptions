package com.mygdx.game;


public class Handler 
{
	private Game game;
	private World world;
	
	public Handler(Game g)
	{
		game = g;
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
	
	public void setGame(Game g)
	{
		game = g;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public void setWorld(World w)
	{
		world = w;
	}
}
