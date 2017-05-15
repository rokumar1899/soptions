package wl.worthless.simplegame.tiles;

import wl.worthless.simplegame.gfx.*;

public class RockTile extends Tile
{
	public RockTile(int id)
	{
		super(Assets.getBrick(), id);
	}
	
	//overiding isSolid
	public boolean isSolid()
	{
		return true;
	}
}
