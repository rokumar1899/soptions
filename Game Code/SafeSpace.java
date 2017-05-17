package com.mygdx.game;

public class SafeSpace extends Structure {

	public SafeSpace(int h, int l, String n)
	{
		super(h, l, false, n);
	}	
	
	private int physicalHeal()
	{
		int h = super.getHealth();
		return h+5;
	}
	private int mentalHeal()
	{
		
	}

}
