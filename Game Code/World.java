package com.mygdx.game;


import java.awt.*;

public class World 
{	
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Handler handler;
	private int timer;
	
	private EntityManager entityManager;
	
	public World(Handler h, String path)
	{
		handler = h;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 100, 450));
		entityManager.addEntity(new Tree(handler, 100, 650));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		timer = 0;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick()
	{
		timer++;
		if(timer >= 120)
		{
			Entity g = new Germ(handler,(int)(Math.random()*1000 + 128), (int)(Math.random()*1000 + 128));
			if(!g.getCollisionBounds(0f, 0f).intersects(entityManager.getPlayer().getCollisionBounds(0f, 0f)))
			{
				entityManager.addEntity(g);
				timer = 0;
				while(g.checkEntityCollisions(0f, 0f))
				{
					g.setX(g.getX()+(int)(Math.random()*6 -3));
					g.setY(g.getY()+(int)(Math.random()*6 -3));
				}
			}	
		}
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILEWIDTH +1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int i = yStart; i < yEnd; i++)
		{
			for(int j = xStart; j < xEnd; j++)
			{
				getTile(j, i).render(g, (int)(j*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int)(i * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
				
			}
		}
		
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width || y >= height)
		{
			return Tile.grassTile;
		}
		
		Tile t= Tile.tiles[tiles[x][y]];
		
		if(t == null)
		{
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path)
	{
		/*
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");// take file and split up every strings
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int i = 0; i< height; i++)
		{
			for(int j = 0; j< width; j++)
			{
				tiles[j][i] = Utils.parseInt(tokens[(j + i * width)+ 4]);
			}
		}
		*/
		width = 20;
		height = 20;
		spawnX = 50;
		spawnY = 50;
		
		tiles = new int[width][height];
		
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				if(i == 0 || i == tiles.length -1)
				{
					tiles[i][j] = 2;
				}
				else if(j == 0 || j == tiles[i].length - 1)
				{
					tiles[i][j] = 2;
				}
				else
				{
					tiles[i][j] = 0;
				}
			}
		}
		
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public boolean gameOver()
	{
		if(entityManager.getNumCreature() >= 30)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

