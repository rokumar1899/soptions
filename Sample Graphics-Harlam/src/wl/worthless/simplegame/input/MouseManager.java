package wl.worthless.simplegame.input;

import java.awt.event.*;

public class MouseManager implements MouseListener, MouseMotionListener
{
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY, cMouseX, cMouseY;
	private long lastTime, currentTime;
	
	public MouseManager()
	{
		lastTime = System.currentTimeMillis();
		currentTime = 0;
	}
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public boolean isUpgradeRof()
	{
		currentTime += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(isLeftPressed() && cMouseX <= 32 && cMouseY >= 608 && currentTime > 100)
		{
			currentTime = 0;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		/*if(e.getButton() == MouseEvent.BUTTON1)//button1 = left click
		{
			leftPressed = true;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightPressed = true;
		}
		*/
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftPressed = true;
		}
		cMouseX = e.getX();
		cMouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)//button1 = left click
		{
			leftPressed = false;
			cMouseX = 0;
			cMouseY = 0;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightPressed = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
	
}
