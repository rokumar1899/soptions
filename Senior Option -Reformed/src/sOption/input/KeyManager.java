package sOption.input;

import java.awt.event.*;

public class KeyManager implements KeyListener
{
	private boolean[] keys;
	public boolean up, down, left, right; // move around
	public boolean interact, attack;// change to x and z
	public boolean pause, select;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		interact = keys[KeyEvent.VK_Z];
		attack = keys[KeyEvent.VK_X];
		
		pause = keys[KeyEvent.VK_P];
		select = keys[KeyEvent.VK_ENTER];
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
		{
			return;
		}
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e){}
	
	public boolean getUP()
	{
		return up;
	}
	
	public boolean getLEFT()
	{
		return left;
	}
	
	public boolean getDOWN()
	{
		return down;
	}
	
	public boolean getRIGHT()
	{
		return right;
	}
	public boolean getZ()
	{
		return interact;
	}
	
	public boolean getX()
	{
		return attack;
	}
	
	public boolean getP()
	{
		return pause;
	}
	
	public boolean getENTER()
	{
		return select;
	}
}
