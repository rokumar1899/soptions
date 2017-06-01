package sOption.worlds;

import java.awt.*;
import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.*;

public abstract class Region 
{
	private static Region currentRegion = null;
	private static int width;
	private static int height;

	protected Connector connector;
	
	public Region(Connector c)
	{
		connector = c;
	}
	
	public static void setRegion(Region region)
	{
		currentRegion = region;
	}
	
	public static Region getRegion()
	{
		return currentRegion;
	}
	
	
	public Connector getConnector()
	{
		return connector;
	}
	
	public static void setWidth(int w)
	{
		width = w;
	}
	
	public static void setHeight(int h)
	{
		height = h;
	}
	
	public static int getWidth()
	{
		return width;
	}
	
	public static int getHeight()
	{
		return height;
	}
	
	public SpriteSheet map;
	public BufferedImage currentMap;
	
	public abstract boolean portalMove();
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
