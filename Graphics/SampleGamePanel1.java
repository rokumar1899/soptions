import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SampleGamePanel1 extends JPanel implements ActionListener, KeyListener
{
	private int locx = 220;
	private int count = 0;
	private int Z = 0;
	private int locy = 100;
	private int locxE = 100;
	private int locyE = 100;
	private int changeX = 0;
	private int changeY = 0;
	private int changeXE = 1;
	private int changeYE = 1;
	private Timer time = new Timer(5, this);
	private boolean appears = false;
	private boolean enemy = false;
	private Rectangle Enemy = null;
	private Rectangle weapon = null;

	public SampleGamePanel1()
	{
		// start timer
		time.start();

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

public void bounce()
	{
		if(locxE==0||locxE==500)
		{
			changeXE=-changeXE;
		}
		if(locyE==0||locyE==500)
		{
			changeYE=-changeYE;
		}
		locxE+=changeXE;
		locyE+=changeYE;
		repaint();
	}

	public void followPlayer()
	{
		if(locyE < locy)
			while(locyE <= locy-150)
				locyE+= 2;
		if(locyE > locy)
			while(locyE >= locy+150)
				locyE-= 2;
		if(locxE < locx)
			while(locxE <= locx-150)
				locxE+= 2;
		if(locxE > locx)
			while(locxE >= locx+150)
				locxE-= 2;
	}

	//draw the panel

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(appears)
		{
			if(Z==-1)
			{
				weapon = new Rectangle(locx+25, locy+20, -100, 10);
				//g.fillRoundRect(locx+25-100, locy+20, 20, 20, 20, 20);
				g.fillOval(locx+25-100, locy+20, 20, 20);
				weapon.setBounds(locx+25-100, locy+20, 100, 10);
			}
			else if(Z==1)
			{
				weapon=new Rectangle(locx+25, locy+20, 100, 10);
				g.fillOval(locx+25, locy+20, 20, 20);
				weapon.setBounds(locx+25, locy+20, 100, 10);
			}
			else if(Z==-2)
			{
				weapon=new Rectangle(locx+20, locy+25, 10, -100);
				g.fillOval(locx+20, locy+25-100, 20, 20);
				weapon.setBounds(locx+20, locy+25-100, 10, 100);
			}
			else if(Z==2)
			{
				weapon=new Rectangle(locx+20, locy+25, 10, 100);
				g.fillOval(locx+20, locy+25, 20, 20);
				weapon.setBounds(locx+20, locy+25, 10, 100);
			}
			else
			{
				weapon=new Rectangle(locx, locy, 0, 0);
				g.fillOval(locx, locy, 20, 20);
				weapon.setBounds(locx, locy, 0, 0);
			}
		}
		if(enemy)
		{
			count++;
			Enemy = new Rectangle(locxE, locyE, 100, 100);
			g.fillRect(locxE, locyE, 100, 100);
			Enemy.setBounds(locxE, locyE, 100, 100);
			if(count==10)
			{
				count=0;
				bounce();
				followPlayer();
			}
		}
		g.fillRect(locx, locy, 50, 50);
	}


	public void actionPerformed(ActionEvent e)
	{
		locx += changeX;
		locy += changeY;
		if(enemy&&appears)
		{
			if((weapon.getBounds()).intersects(Enemy.getBounds()))
			{
				enemy=false;
			}
		}
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		if(c==KeyEvent.VK_LEFT)
		{
			Z=-1;
			changeX-=2;
		}
		if(c==KeyEvent.VK_RIGHT)
		{
			Z=1;
			changeX +=2;
		}
		if(c==KeyEvent.VK_DOWN)
		{
			Z=2;
			changeY+=2;
		}
		if(c==KeyEvent.VK_UP)
		{
			Z=-2;
			changeY -=2;
		}
		if(c==KeyEvent.VK_SPACE)
		{
			appears = true;
		}
		if(c==KeyEvent.VK_1)
		{
			enemy = true;
		}
	}


	public void keyReleased(KeyEvent e)
	{
		int c = e.getKeyCode();
		if(c==KeyEvent.VK_LEFT||c==KeyEvent.VK_RIGHT)
		{
			changeX=0;
		}
		if(c==KeyEvent.VK_UP||c==KeyEvent.VK_DOWN)
		{
			changeY=0;
		}
		if(c==KeyEvent.VK_SPACE)
		{
			appears = false;
		}
	}

	public void keyTyped(KeyEvent e)
	{

	}
}