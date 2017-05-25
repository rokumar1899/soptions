package sOption.worlds;

import java.awt.*;
import sOption.Connector;
import sOption.gfx.Assets;

public class Beach extends Region
{
	public Beach(Connector c)
	{
		super(c);
		setRegion(this);
		map = Assets.beach;
		
	}

	@Override
	public boolean portalMove() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		int xStart = (int)connector.getGameCamera().getxOffset();
		int yStart = (int)connector.getGameCamera().getyOffset();
		
		g.drawImage(map, xStart, yStart, connector.getWidth(), connector.getHeight(), null);
	
		
	}
	
}
