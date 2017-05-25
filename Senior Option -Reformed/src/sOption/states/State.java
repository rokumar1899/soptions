package sOption.states;

import java.awt.*;
import sOption.Connector;

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
    
    protected Connector connector;
    
    public State(Connector c)
    {
        connector = c;
    }
    
    public Connector getConnector()
    {
    	return connector;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);

}
