package wl.worthless.simplegame;  


import wl.worthless.simplegame.input.*;
import wl.worthless.simplegame.states.*;
import wl.worthless.simplegame.gfx.*;
import wl.worthless.simplegame.display.*;

import java.awt.image.*;
import java.awt.*;

public class Game implements Runnable
{
  private Display display;

  private int width, height;
  private String title;

  private boolean running = false;
  private Thread thread;

  private BufferStrategy bs; //a way of computer to draw things to screen Buffer = a hidden computer screen within the computer
  private Graphics graphics;

  public State gameState;
  public State menuState;
  public State gameOverState;
  
  private KeyManager keyManager;
  private MouseManager mouseManager;

  private GameCamera gameCamera;
  
  private Handler handler;

  public Game(String t, int w, int h)
  {
      title = t;
      width = w;
      height = h;
      keyManager = new KeyManager();
      mouseManager = new MouseManager();
  }

  private void init()
  {
      display = new Display(title, width, height);
      display.getFrame().addKeyListener(keyManager);
      display.getFrame().addMouseListener(mouseManager);
      display.getFrame().addMouseMotionListener(mouseManager);
      
      display.getCanvas().addMouseListener(mouseManager);
      display.getCanvas().addMouseMotionListener(mouseManager);
      
      Assets.init();

      handler = new Handler(this);
      gameCamera = new GameCamera(handler, 0,0);
      
      gameState = new GameState(handler);
      menuState = new MenuState(handler);

      State.setState(menuState);
  }

  private void tick() //updating status before render
  {
      keyManager.tick();

      if(State.getState() != null)
      {
          State.getState().tick();
      }
      if(State.getState().gameOver())
      {
    	  gameOverState = new GameOverState(handler, ((GameState)gameState).getScore());
    	  State.setState(gameOverState);
    	  gameState = new GameState(handler);
      }
  }

  private void render() //drawing on screen
  {
      bs = display.getCanvas().getBufferStrategy();
      if(bs == null)
      {
          display.getCanvas().createBufferStrategy(3);
      }
      else
      {
          graphics = bs.getDrawGraphics();
          //clear Screen
          graphics.clearRect(0, 0, width, height);
          //Draw stuff here

          if(State.getState() != null)
          {
              State.getState().render(graphics);
          }
          //End of render
          bs.show();
          graphics.dispose();
      }
  }

  public void run()
  {
      init();

      int fps = 60;
      double timePerTick = 1000000000 / fps; // maximum amount of time to reach one tick
      double delta = 0; // tells computer when and when not to call these tick and render methods.
      long now; // current time of computer
      long lastTime = System.nanoTime(); //Current time of computer in nano seconds
      //long timer = 0;
      //int ticks = 0;

      while(running)
      {
          now = System.nanoTime();
          delta += (now - lastTime) / timePerTick; //dividing amount of time by time per tick;
         // timer += now - lastTime; // amount of nanoseconds passed since last Time;
          lastTime = now; // lastTime will be equal to current variable.

          if(delta >= 1) // we have to tick and render before delta reaches more than 1
          {
              tick();
              render();
              //ticks++;
              delta--;
          }
/*
          if(timer >= 1000000000) // checks if these ticks are working correctly
          {
          System.out.println("Ticks and Frames: "+ticks);
          ticks = 0;
          timer = 0;
          }
*/
      }

      stop();
  }

  public KeyManager getKeyManager()
  {
      return keyManager;
  }

  public MouseManager getMouseManager()
  {
	  return mouseManager;
  }
  
  public GameCamera getGameCamera()
  {
	  return gameCamera;
  }

  public int getWidth()
  {
	  return width;
  }

  public int getHeight()
  {
	  return height;
  }

  public synchronized void start()
  {
      if(running)
      {
      }
      else
      {
          running = true;
          thread = new Thread(this);
          thread.start();
      }
  }

  public synchronized void stop()
  {
      if(!running)
      {
      }
      else
      {
          running = false;
          try
          {
              thread.join();
          }
          catch(InterruptedException e)
          {
              e.printStackTrace();
          }
      }
  }
}
