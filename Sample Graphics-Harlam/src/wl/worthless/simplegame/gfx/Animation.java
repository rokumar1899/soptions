package wl.worthless.simplegame.gfx;

import java.awt.image.BufferedImage;

public class Animation 
{
	private int speed, index;
	private long lastTime, timer, timerG;
	private BufferedImage[] frames;
	
	public Animation(int s, BufferedImage[] f, long t)
	{
		speed = s;
		frames = f;
		index = 0;
		timer = 0;
		timerG = t;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed)
		{
			index++;
			timer = 0;
			if(index >= frames.length)
			{
				index = 0;
			}
		}
	}
	
	public boolean mTimer()
	{
		if(timer == timerG)
			return true;
		else
			return false;
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}
