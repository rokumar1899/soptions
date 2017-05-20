package src.entities.Structure;

import src.Handler;
import src.entities.Unit.NPC;

public class Tower extends Structure 
{
	private NPC one, two;
	
	
	public Tower(Handler han, float x, float y, int w, int he, int h, int mh, int l, String n)
	{
		super(han, x, y, w, he, h, mh, l, n);
		one = new NPC(han, x, y-10, this.getMaxHealth());
		two = new NPC(han, x+5, y-10, this.getMaxHealth());
	}
	
	public Item shoot()
    {
    	Item b;
    	if(handler.getKeyManager().getUp())
    	{ 
    		b = new Bullet(handler, getX() + (width/2), getY() + (height/2), "N");
    		return b;
    	}
    	else if(handler.getKeyManager().getDown())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + height+10, "S");
    		return b;
    	}
    	else if(handler.getKeyManager().getLeft())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + (height/2), "W");
    		return b;
    	}
    	else if(handler.getKeyManager().getRight())
    	{
    		b= new Bullet(handler, getX() + (width/2), getY() + (height/2), "E");
    		return b;
    	}
    	else
    	{
    		return null;
    	}
    }
	
	
	
	

}
