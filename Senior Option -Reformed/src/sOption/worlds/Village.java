package sOption.worlds;

import java.awt.*;
import sOption.Connector;
import sOption.gfx.Assets;

public class Village extends Region
{
	public Village(Connector c)
	{
		super(c);
		setWidth(10000);
		setHeight(8000);
		setRegion(this);
		map = Assets.village;
	}
	
	public boolean portalMove()
	{
		return false;
	}
	
	public void tick()
	{
		int xStart = (int)connector.getGameCamera().getxOffset();
		int yStart = (int)connector.getGameCamera().getyOffset();
		
		currentMap = map.crop(xStart, yStart, connector.getWidth(), connector.getHeight());
	}
	
	public void render(Graphics g)
	{
		g.drawImage(currentMap, 0, 0, connector.getWidth(), connector.getHeight(), null);
	}
}
