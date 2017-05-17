package src.states;

import java.awt.Graphics;
import java.awt.*;

public class GameState extends State
{    
    private World world;
    private int score;
    
    public GameState(Handler h)
    {
        super(h);
        world = new World(handler, "res/worlds/world.txt");
        handler.setWorld(world);
        score = 0;
    }
    
    public void tick()
    {
    	world.tick();
    }
    
    public boolean gameOver()
    {
    	if(world.gameOver())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public void addScore(int s)
    {
    	score += s;
    }
    
    public int getScore()
    {
    	return score;
    }
    
    public void render(Graphics g)
    {
    	world.render(g);
    	g.setColor(Color.ORANGE);
    	g.drawString("Score: "+score, 30, 30);
    	g.setColor(Color.RED);
    	g.drawString("Number of Germs : "+handler.getWorld().getEntityManager().getNumCreature()+"/30", 30, 70);
    	g.setColor(Color.GREEN);
    	g.drawString("Money: "+handler.getWorld().getEntityManager().getPlayer().getMoney(), 30, 90);
		g.drawImage(Assets.getRof(), 0, handler.getHeight()-32, null);
    }
}
