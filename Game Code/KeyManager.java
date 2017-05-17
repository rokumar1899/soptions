package com.mygdx.game;

import java.awt.event.*;

public class KeyManager implements KeyListener
{
    private boolean[] keys; //every singles keys in keyboard has key code
    private boolean w, s, a, d, r, tKey, up, down, left, right;

    public KeyManager()
    {
        keys = new boolean[256];
    }

    public void tick()
    {
        w = keys[KeyEvent.VK_W];
        s = keys[KeyEvent.VK_S];
        a = keys[KeyEvent.VK_A];
        d = keys[KeyEvent.VK_D];
        r = keys[KeyEvent.VK_R];
        tKey = keys[KeyEvent.VK_T];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    public boolean getW()
    {
        return w;
    }

    public boolean getS()
    {
        return s;
    }

    public boolean getA()
    {
        return a;
    }

    public boolean getD()
    {
        return d;
    }
    
    public boolean getR()
    {
    	return r;
    }
    
    public boolean getT()
    {
    	return tKey;
    }
    
    public boolean getUp()
    {
    	return up;
    }
    
    public boolean getDown()
    {
    	return down;
    }
    
    public boolean getLeft()
    {
    	return left;
    }
    
    public boolean getRight()
    {
    	return right;
    }

    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        //System.out.println("Pressed");
    }

    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e)
    {
    }
}

