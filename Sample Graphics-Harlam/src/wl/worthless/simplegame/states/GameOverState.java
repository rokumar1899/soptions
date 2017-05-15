package wl.worthless.simplegame.states;

import wl.worthless.simplegame.*;
import wl.worthless.simplegame.gfx.Assets;

import java.awt.*;

public class GameOverState extends State
{
	private String instruction;
	private String result;
	
	public GameOverState(Handler h, int Score)
	{
		super(h);
		result = "Your score is: "+Score;
		instruction = "Press \"R\" to Retry";
	}
	
	public void tick()
	{
		if(handler.getKeyManager().getR())
		{
			State.setState(handler.getGame().gameState);
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
		  g.drawString(instruction, handler.getWidth()/2, handler.getHeight()/2);
		  g.setColor(Color.RED);
		  g.fillOval(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
	}
}
