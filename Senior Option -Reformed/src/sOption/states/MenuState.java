package sOption.states;

import java.awt.*;

import sOption.Connector;

public class MenuState extends State
{
	private String instruction;
	
	public MenuState(Connector c)
	{
		super(c);
		instruction = "Press \"ENTER\" to Start";
	}
	
	public void tick()
	{
		if(connector.getKeyManager().getENTER())
		{
			State.setState(connector.getGame().gameState);
		}
	}
	
	public boolean gameOver() 
	{
		return false;
	}

	public void render(Graphics g) 
	{
		g.drawString(instruction, connector.getWidth()/2, connector.getHeight()/2);
		g.setColor(Color.BLACK);
	}
	
}
