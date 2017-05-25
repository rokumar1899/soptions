package sOption.worlds;

import java.awt.*;
import java.awt.image.BufferedImage;

import sOption.Connector;

public abstract class Region 
{
	private static Region currentRegion = null;
	
	public static void setRegion(Region region)
	{
		currentRegion = region;
	}
	
	public static Region getRegion()
	{
		return currentRegion;
	}
	
	protected Connector connector;
	
	public Region(Connector c)
	{
		connector = c;
	}
	
	public Connector getConnector()
	{
		return connector;
	}
	
	public BufferedImage map;
	
	public abstract boolean portalMove();
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
