import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class Boarders
{
	private ArrayList<Rectangle> bounds;
	private Rectangle BU = null;
	private Rectangle BR = null;
	private Rectangle BL = null;
	private Rectangle BB = null;


	public Boarders()
	{
		bounds = new ArrayList<Rectangle>();
		BU = new Rectangle(0, 0, 900, 10);
		BR = new Rectangle(889, 0, 10, 900);
		BL = new Rectangle(0, 0, 10, 899);
		BB = new Rectangle(0, 889, 900, 10);
		bounds.add(BU);
		bounds.add(BR);
		bounds.add(BL);
		bounds.add(BB);
	}
	public ArrayList<Rectangle> getBounds()
	{
		return bounds;
	}

}