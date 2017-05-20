package src.states;

import java.awt.*;
import src.Handler;
import src.gfx.Assets;

public class GameOverState extends State
{
	private String result;
	
	public GameOverState(Handler h, int Score)
	{
		super(h);
		//result = "You died in ___ days";
	}
	
	public void tick()
	{
		if(handler.getKeyManager().getP())
		{
			//State.setState(handler.getGame().pauseState);
		}
	}
	
	public boolean gameOver()
	{
		return false;
	}
	
	public void render(Graphics g)
	{
		  g.drawImage(Assets.getGameOver(), handler.getWidth()/2, handler.getHeight()/2, null);
		  g.drawString(result, handler.getWidth()/2, handler.getHeight()/2 - 100);
		  g.setColor(Color.RED);
		  //g.fillOval(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
	}

}

