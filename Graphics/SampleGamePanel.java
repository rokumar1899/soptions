import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class SampleGamePanel extends JPanel implements ActionListener, KeyListener
{
	private boolean gameOver=false;
	private int locx = 220;
	private int count = 0;
	private int count1 = 0;
	private int count2 = 0;
	private int count5 = 0;
	private int Z = 0;
	private int G = 0;
	private int locy = 100;
	private int changeX = 0;
	private int changeY = 0;
	private Timer time = new Timer(10, this);
	private boolean appears = false;
	private boolean enemy = false;
	private Rectangle weapon = null;
	private Rectangle Player = null;
	private ArrayList<Rectangle> Boundaries;
	private Boarders B;
	private Level level;
	private int lvl=1;
	private ArrayList<Enemy> enemies;
	private JLabel L = new JLabel();
	private ArrayList<Bullet> bullets;
	private boolean Gun = false;
	private int HP = 3;
	private int count4 = 0;
	private int count3 = 0;
	private int countL = 0;
	private Rectangle S;
	private boolean Shield;
	private boolean Boss=false;
	private Boss boss = new Boss();
	private Rectangle BS;
	private int C = 0;
	private Image Link;
	private Image Ganon;
	private Image EE;
	private Image GanonUp;
	private Image GanonLeft;
	private Image GanonRight;
	private JLabel L2 = new JLabel();
	private Image heart;
	private Image heart2;
	private Image heart3;
	private Image LinkHurt;
	private Image LinkLeft;
	private boolean hurt;
	private Image end;
	private Image laser;
	private Image laserL;
	private Image laserU;
	private Image laserD;
	private int ammo = 10;
	private JLabel L3 = new JLabel();
	private Image Bomb;
	private Image Bomb1;
	private Image Bomb2;
	private Image Boom;
	private Image LD;

	public SampleGamePanel()
	{
		// start timer
		time.start();

		level = new Level(lvl);
		enemies = level.createEnemies();
		bullets = new ArrayList<Bullet>();
		B = new Boarders();
		Boundaries = B.getBounds();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		L.setText("");
		L.setLayout(null);
		L.setBounds(100, 400, 490, 490);
		add(L);
		add(L2);
		add(L3);
		Link = new ImageIcon("Pictures\\Link.png").getImage();
		Ganon = new ImageIcon("Pictures\\Boss.png").getImage();
		GanonUp = new ImageIcon("Pictures\\BossUp.png").getImage();
		GanonLeft = new ImageIcon("Pictures\\BossLeft.png").getImage();
		GanonRight = new ImageIcon("Pictures\\BossRight.png").getImage();
		EE = new ImageIcon("Pictures\\EE.png").getImage();
		heart = new ImageIcon("Pictures\\heart20.png").getImage();
		heart2 = new ImageIcon("Pictures\\heart20.png").getImage();
		heart3 = new ImageIcon("Pictures\\heart20.png").getImage();
		LinkHurt = new ImageIcon("Pictures\\LinkHurt.png").getImage();
		LinkLeft = new ImageIcon("Pictures\\LinkLeft.png").getImage();
		hurt = false;
		end = new ImageIcon("Pictures\\TheEnd.png").getImage();
		laser = new ImageIcon("Pictures\\Arrow.png").getImage();
		laserL = new ImageIcon("Pictures\\ArrowLeft.png").getImage();
		laserU = new ImageIcon("Pictures\\ArrowUp.png").getImage();
		laserD = new ImageIcon("Pictures\\ArrowDown.png").getImage();
		Bomb = new ImageIcon("Pictures\\Bomb.png").getImage();
		Bomb1 = new ImageIcon("Pictures\\Bomb1.png").getImage();
		Bomb2 = new ImageIcon("Pictures\\Bomb2.png").getImage();
		Boom = new ImageIcon("Pictures\\Boom.png").getImage();
		LD = new ImageIcon("Pictures\\LD.png").getImage();
	}


	//draw the panel

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(gameOver)
		{
			g.drawImage(end, 1, 30, null);
			L.setText("Game Over...Press Q to Quit...Press R to Restart");
			L.setLayout(null);
			L.setBounds(100, 200, 890, 10);
		}
		else
		{
			if(HP==3)
			{
			g.drawImage(heart, 800, 9, null);
			g.drawImage(heart2, 818, 9, null);
			g.drawImage(heart3, 836, 9, null);
			}
			else if(HP==2)
			{
			g.drawImage(heart, 800, 9, null);
			g.drawImage(heart2, 818, 9, null);
			}
			else if(HP==1)
			{
			g.drawImage(heart, 800, 9, null);
			}

			L.setText("");
		for(int x = 0; x<Boundaries.size(); x++)
		{
			Rectangle R = Boundaries.get(x);
			if(x==0)
			{
				g.setColor(Color.red);
			}
			if(x==1)
			{
				g.setColor(Color.yellow);
			}
			if(x==2)
			{
				g.setColor(Color.green);
			}
			if(x==3)
			{
				g.setColor(Color.blue);
			}
			g.fillRect((int)R.getX(), (int)R.getY(), (int)R.getWidth(), (int)R.getHeight());
		}
		g.setColor(Color.black);
		if(appears)
		{
			if(Z==-1)
			{
				weapon = new Rectangle(locx-27, locy+8,50, 4);
			}
			else if(Z==1)
			{
				weapon=new Rectangle(locx+10, locy+8, 50, 4);
			}
			else if(Z==-2)
			{
				weapon=new Rectangle(locx+8, locy-40,4, 55);
			}
			else if(Z==2)
			{
				g.setColor(Color.yellow);
				weapon=new Rectangle(locx+8, locy+30, 4, 35);
			}
			else
			{
				weapon=new Rectangle(locx, locy, 0, 0);
			}
			g.fillRect((int)weapon.getX(), (int)weapon.getY(), (int)weapon.getWidth(), (int)weapon.getHeight());
			weapon.setBounds((int)weapon.getX(), (int)weapon.getY(), (int)weapon.getWidth(), (int)weapon.getHeight());
		}
		if(enemy&&lvl<=1)
		{
			count2++;
			for(int x = 0; x<enemies.size(); x++)
			{
				Enemy E = enemies.get(x);
				if(x!=0&&x%2==0)
				{
					followPlayer();
				}
				else if(count2%10==0)
				{
					E.directionChange(lvl);
				}
				E.moveEnemy();
				Rectangle ER = E.getEnemy();
				E.bounce();
				g.drawImage(EE,(int)ER.getX()-60, (int)ER.getY()-50, null);
				//g.fillRect((int)ER.getX(), (int)ER.getY(), (int)ER.getWidth()+15, (int)ER.getHeight()+15);
				ER.setBounds((int)ER.getX(), (int)ER.getY(), (int)ER.getWidth(), (int)ER.getHeight());
			}
		}
		g.setColor(Color.black);
		if((Gun&&count2%30==0)&&ammo>0)
		{
			bullets.add(new Bullet(locx+8, locy+8, G));
			ammo--;
		}
		if(bullets.size()>=1)
		{
			for(int x = 0; x<bullets.size(); x++)
			{
				Bullet B = bullets.get(x);
			if(B.getG()==-1)
			{
				Rectangle Bu = B.getBullet();
				B.moveBulletL();
				g.drawImage(laserL, (int)Bu.getX()-10, (int)Bu.getY(), null);
			}
			else if(B.getG()==1)
			{
				Rectangle Bu = B.getBullet();
				B.moveBulletR();
				g.drawImage(laser, (int)Bu.getX()-10, (int)Bu.getY()-15, null);
			}
			else if(B.getG()==-2)
			{
				Rectangle Bu = B.getBullet();
				B.moveBulletU();
				g.drawImage(laserU, (int)Bu.getX()-30, (int)Bu.getY()-30, null);
			}
			else if(B.getG()==2)
			{
				Rectangle Bu = B.getBullet();
				B.moveBulletD();
				g.drawImage(laserD, (int)Bu.getX()-30, (int)Bu.getY()-30, null);
			}
			//Rectangle Bu = B.getBullet();
			//g.drawImage(laser, (int)Bu.getX()-10, (int)Bu.getY()-20, null);
			//g.fillRect((int)Bu.getX(), (int)Bu.getY(), (int)Bu.getWidth(), (int)Bu.getHeight());
			if(B.getDistance())
			{
				bullets.remove(x);
				x--;
			}
		}
		}
		if(hurt)
		{
			g.drawImage(LinkHurt, locx-60, locy-50, null);
			//g.fillRect(locx-8, locy-10, 35, 90);
			Player = new Rectangle(locx, locy, 35, 70);
			g.setColor(Color.black);
			if(countL%50==0)
			{
				hurt = false;
			}
			countL++;
		}
		else
		{
			if(Z == -1)
			{
				g.drawImage(LinkLeft,locx-60, locy-50, null);
				Player = new Rectangle(locx, locy, 35, 50);
			}
			else if(Z == 2)
			{
				g.drawImage(LD, locx-20, locy-50, null);
				Player = new Rectangle(locx, locy, 35, 50);
			}
			else
			{
				g.drawImage(Link, locx-60, locy-50, null);
				//g.fillRect(locx-8, locy-10, 35, 50);
				Player = new Rectangle(locx, locy, 35, 50);
				g.setColor(Color.black);
			}
		}
		//g.fillRect(locx-8, locy-10, 35, 50);
		L2.setText("Lives: ");
		L2.setLayout(null);
		L2.setBounds(780, 30, 890, 10);
		L3.setText("Ammo: "+ammo);
		L3.setLayout(null);
		L3.setBounds(50, 30, 890, 10);
		if(Boss)
		{
			BS = boss.getBoss();
			//g.fillRect(225, 225, 50, 50);
			if(C==0)
			{
				//g.setColor(Color.black);
				C=(int)(Math.random()*4+1);
				count5++;
			}
			if(C==1)
			{
				//g.setColor(Color.red);
				g.drawImage(GanonUp, 190, 190, null);
				count5++;
				if(count5%200==0)
				{
					if(locy<=225)
					{
						HP--;
					}
					if(HP<=0)
					{
					gameOver = true;
					repaint();
					}
					count5=0;
					C=0;
					repaint();
				}
			}
			else if(C==2)
			{
				g.drawImage(Ganon, 190, 190, null);
				//g.setColor(Color.blue);
				count5++;
				if(count5%200==0)
				{
					if(locy>=275)
					{
						HP--;
					}
					if(HP<=0)
					{
					gameOver = true;
					repaint();
					}
					count5=0;
					C=0;
					repaint();
				}
			}
			else if(C==3)
			{
				g.drawImage(GanonLeft, 190, 190, null);
				//g.setColor(Color.green);
				count5++;
				if(count5%200==0)
				{
					if(locx<=225)
					{
						HP--;
					}
					if(HP<=0)
					{
					gameOver = true;
					repaint();
					}
					count5=0;
					C=0;
					repaint();
				}
			}
			else if(C==4)
			{
				g.drawImage(GanonRight, 190, 190, null);
				//g.setColor(Color.yellow);
				count5++;
				if(count5%200==0)
				{
					if(locx>=275)
					{
						HP--;
					}
					if(HP<=0)
					{
					gameOver = true;
					repaint();
					}
					count5=0;
					C=0;
					repaint();
				}
			}
			//g.fillRect(225, 225, 50, 50);
		}
	}
	}



	public void actionPerformed(ActionEvent e)
	{
		if(appears)
		{
			changeX=changeX/2;
			changeY=changeY/2;
			locx += changeX;
			locy += changeY;
			changeX=changeX*2;
			changeY=changeY*2;
		}
		else
		{
			locx += changeX;
			locy += changeY;
		}
		if(count1==4)
		{
			testMove();
			count1=0;
		}
		count1++;
		if(enemy&&appears)
		{
			count3++;
			for(int x = 0; x<enemies.size(); x++)
			{
				Enemy E = enemies.get(x);
				if((weapon.getBounds()).intersects(E.getEnemyBounds())&&count3>=10)
				{
					E.removeHealth(3);
					count3 = 0;
					if(E.getHealth()<=0)
					{
						enemies.remove(x);
						x--;
						repaint();
					}
				}
				repaint();
			}
			if(enemies.size()==0)
			{
				lvl++;
				if(lvl>1)
				{
					enemy = false;
					Boss = true;
					repaint();
				}
				else
				{
				level= new Level(lvl);
				enemies = level.createEnemies();
				}
				repaint();
			}
		}
			//repaint();
		if(Boss&&appears)
		{
			count3++;
				if((weapon.getBounds()).intersects(boss.getBossBounds())&&count3>=10)
				{
					boss.removeBHealth(3);
					if(boss.getBHealth()<=0)
					{
						Boss = false;
					}
				}
				repaint();
		}
		if(enemy)
		{
			count4++;
			for(int x = 0; x<enemies.size(); x++)
			{
				Enemy E = enemies.get(x);
				if((Player.getBounds()).intersects(E.getEnemyBounds())&&count4>=40)
				{
					hurt = true;
					HP = HP-1;
					count4=0;
					if(HP<=0)
					{
					gameOver = true;
					repaint();
					}
				}
				//repaint();
			}

		}
		//repaint();
		if(Gun&&enemy)
		{
			for(int x = 0; x<bullets.size(); x++)
			{
				Bullet B = bullets.get(x);
				for(int y = 0; y<enemies.size(); y++)
			{
				Enemy E = enemies.get(y);
				if((B.getBulletBounds()).intersects(E.getEnemyBounds()))
				{
					E.removeHealth(2);
					if(E.getHealth()<=0)
					{
						enemies.remove(y);
						y--;
					}
					bullets.remove(x);
					x--;
				}
				//repaint();
			}
			if(enemies.size()==0)
			{
				lvl++;
				ammo= 10+((lvl-1)*5);
				if(lvl>1)
				{
					enemy = false;
					Boss = true;
					repaint();
				}
				else
				{
				level= new Level(lvl);
				enemies = level.createEnemies();
				}
				repaint();
			}
			//repaint();
		}
		}
		if(Gun&&Boss)
		{
			for(int x = 0; x<bullets.size(); x++)
			{
				Bullet B = bullets.get(x);
				if((B.getBulletBounds()).intersects(boss.getBossBounds()))
				{
					boss.removeBHealth(2);
					if(boss.getBHealth()<=0)
					{
						Boss = false;
						gameOver = true;
						repaint();
					}
					bullets.remove(x);
					x--;
				}
				//repaint();
			}
		}
	repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		if(c==KeyEvent.VK_SPACE)
		{
			appears = true;
		}
		if(c==KeyEvent.VK_ENTER)
		{
			Gun = true;
		}
		if(c==KeyEvent.VK_LEFT)
		{
			G=-1;
			Z=-1;
			changeX=-2;
			testMove();
		}
		if(c==KeyEvent.VK_RIGHT)
		{
			Z=1;
			G=1;
			changeX =2;
			testMove();
		}
		if(c==KeyEvent.VK_DOWN)
		{
			G=2;
			Z=2;
			changeY=2;
			testMove();
		}
		if(c==KeyEvent.VK_UP)
		{
			Z=-2;
			G=-2;
			changeY =-2;
			testMove();
		}
		if(c==KeyEvent.VK_1||c==KeyEvent.VK_2)
		{
			enemy = true;
		}
		if(gameOver)
		{
			if(c==KeyEvent.VK_R)
			{
				gameOver=false;
				lvl=1;
				ammo = 10;
				level = new Level(lvl);
				enemies = level.createEnemies();
				HP=3;
		//	for(int x = 0; x<enemies.size(); x++)
		//	{
			//	Enemy E = enemies.get(x);
				//E.setHealth(3);
		//	}
				repaint();
			}
			else if(c==KeyEvent.VK_Q)
			{
				SampleMenuScreen sms = new SampleMenuScreen();
				sms.display();
			}
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
		if(c==KeyEvent.VK_ENTER)
		{
			Gun = false;
		}
	}

	public void keyTyped(KeyEvent e)
	{

	}
	public void testMove()
	{
			if(locx<= 10.0)
			{
				locx=11;
				changeX=0;
			}
			if(locx+20.0>=889.0)
			{
				locx=868;
				changeX=0;
			}
			else if(locy<=10.0)
			{
				locy=11;
				changeY=0;
			}
			else if(locy+20.0>=889.0)
			{
				locy=868;
				changeY=0;
			}
	}
	public boolean getGame()
	{
		return gameOver;
	}
	public void followPlayer()
	{
		for(int x = 0; x<enemies.size(); x++)
		{
			if(x!=0&&x%2==0)
			{
			Enemy E = enemies.get(x);
			Rectangle ER = E.getEnemy();
			if(ER.getY()<locy)
				E.changeY(1);
			if(ER.getY()>locy)
				E.changeY(-1);
			if(ER.getX()<locx)
				E.changeX(1);
			if(ER.getX()>locx)
				E.changeX(-1);
			}
		}
	}
	public void playSound() 
	{
    	
	}
}