package src.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right;// move around
	public boolean interact, attack;// change to x and z to interact/pickup and attack respectively
	public boolean pause, select; 
	
	public KeyManager(){
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick(){
		for(int i = 0;i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i] = false;
			}
			else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i] = true;
			}
		}
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		interact = keys[KeyEvent.VK_Z];
		attack = keys[KeyEvent.VK_X];
		
		pause = keys[KeyEvent.VK_P];
		select = keys[KeyEvent.VK_ENTER];
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	public boolean getUP()
	{
		if(keyJustPressed(KeyEvent.VK_UP))
				return true;
		return false;
	}
	public boolean getLEFT()
	{
		if(keyJustPressed(KeyEvent.VK_LEFT))
			return true;
		return false;
	}
	public boolean getDOWN()
	{
		if(keyJustPressed(KeyEvent.VK_DOWN))
			return true;
		return false;
	}
	public boolean getRIGHT()
	{
		if(keyJustPressed(KeyEvent.VK_RIGHT))
			return true;
		return false;
	}
	public boolean getZ()
	{
		if(keyJustPressed(KeyEvent.VK_Z))
			return true;
		return false;
	}
	public boolean getX()
	{
		if(keyJustPressed(KeyEvent.VK_X))
			return true;
		return false;
	}
	public boolean getP()
	{
		if(keyJustPressed(KeyEvent.VK_P))
			return true;
		return false;
	}
	public boolean getENTER()
	{
		if(keyJustPressed(KeyEvent.VK_ENTER))
			return true;
		return false;
	}

}
