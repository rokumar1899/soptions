package wl.worthless.simplegame.entities.statics;

import java.awt.Graphics;
import wl.worthless.simplegame.*;
import wl.worthless.simplegame.gfx.*;
import wl.worthless.simplegame.tiles.*;

public class Tree extends StaticEntity
{
	public Tree(Handler han, float x, float y)
	{
		super(han, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
	
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.getTree(), (int)(xPoint - handler.getGameCamera().getxOffset()), (int)(yPoint - handler.getGameCamera().getyOffset()), width, height, null);
	}
}
