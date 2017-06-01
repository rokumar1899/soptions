package sOption.gfx;

import sOption.Connector;
import sOption.entities.Entity;
import sOption.worlds.Region;

public class GameCamera 
{
	private Connector connector;
	private float xOffset, yOffset;
	
	public GameCamera(Connector connector, float xOffset, float yOffset)
	{
		this.connector = connector;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace()
	{
		if(xOffset < 0)
		{
			xOffset = 0;
		}
		else if(xOffset > Region.getWidth()- connector.getWidth())
		{
			xOffset = Region.getWidth() - connector.getWidth();
		}
		
		if(yOffset < 0)
		{
			yOffset = 0;
		}
		else if(yOffset > Region.getHeight() - connector.getHeight())
		{
			yOffset = Region.getHeight() - connector.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e)
	{
		xOffset = e.getXloc() - connector.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getYloc() - connector.getHeight()/2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
