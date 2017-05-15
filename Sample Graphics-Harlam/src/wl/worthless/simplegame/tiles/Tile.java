package wl.worthless.simplegame.tiles;

import java.awt.image.*;
import java.awt.*;

public class Tile 
{
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	
	protected BufferedImage texture;
	protected final int id;

	public static final int TILEWIDTH = 64, TILEHEIGHT =64;
	
	public Tile(BufferedImage t, int i)
	{
		texture = t;
		id = i;
		
		tiles[id] = this;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public int getId()
	{
		return id;
	}
}
