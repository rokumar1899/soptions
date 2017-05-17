package com.mygdx.game;

import java.awt.*;

public abstract class State
{
    private static State currentState = null;

    public static void setState(State state)
    {
        currentState = state;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    protected Handler handler;
    
    public State(Handler h)
    {
        handler = h;
    }
    
    public Handler getHandler()
    {
    	return handler;
    }
    
    public abstract boolean gameOver();
    public abstract void tick();

    public abstract void render(Graphics g);

}



