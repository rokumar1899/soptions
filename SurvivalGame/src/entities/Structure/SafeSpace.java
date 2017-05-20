package src.entities.Structure;

import src.entities.Entity;
import src.entities.Unit.*;

import java.awt.Graphics;

import src.Handler;

public class SafeSpace extends Structure 
{
	protected static boolean inSafeSpace = false;
	private static final int mentalHealAmt = 20;
	private static final int physicalHealAmt = 10;
	private static final int hungerIncAmt = -10;
	private static final int thirstIncAmt = -5;
	
	public SafeSpace(Handler han, float x, float y, int width, int l)
	{
		super(han, x, y, width, width, 1000, 1000, l, "CAMP");
		Player player = handler.getWorld().getEntityManager().getPlayer();
		if(this.checkEntityCollision(player.getXloc(), player.getYloc()))
				SafeSpace.inSafeSpace = true;
	}	
	
	@Override
	public void tick(){
		Player x = handler.getWorld().getEntityManager().getPlayer();
		int a = x.getHealth();
		int b = x.getMentalHealth();
		int c = x.getHunger();
		int d = x.getThirst();
		x.setHealth(a+=physicalHealAmt);
		x.setMentalHealth(b+=mentalHealAmt);
		x.setHunger(c+=hungerIncAmt);
		x.setThirst(d+=thirstIncAmt);
		for(Entity z : handler.getWorld().getEntityManager().getEntities())
			z.setCanAttack(false);
	}

	@Override
	public void render(Graphics g){
		
	}

}
