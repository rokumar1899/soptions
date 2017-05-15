package wl.worthless.simplegame.entities.statics;

import wl.worthless.simplegame.*;
import wl.worthless.simplegame.entities.*;

public abstract class StaticEntity extends Entity
{
	public StaticEntity(Handler han, float x, float y, int w, int h)
	{
		super(han, x, y, w, h);
	}
}
