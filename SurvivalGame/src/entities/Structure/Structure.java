package src.entities.Structure;

import src.entities.Entity;
import src.Handler;
import java.awt.Graphics;

public class Structure extends Entity 
{
	private String name;// name of the structure
	//private final ArrayList<String> TYPES= new ArrayList<String>(Arrays.asList("Building", "Tower"));
	
	public Structure(Handler han, float x, float y, int w, int he, int h, int mh, int l, String n) 
	{
		super(han, x, y, w, he, h, mh, l, true, false);
		setName(n);
	}

	@Override
	public void tick(){}

	@Override
	public void render(Graphics g){}
	
	 public boolean checkEntityCollision(float xOffset, float yOffset)
	  {
	  		for(Entity e: handler.getWorld().getEntityManager().getEntities())
	  		{
	  			if(e.equals(this))// skip itself
	  			{
	  				continue;
	  			}
	  			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
	  			{
	  				return true;
	  			}	
	  		}
	  		return false;
	  }
	 
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	
}

