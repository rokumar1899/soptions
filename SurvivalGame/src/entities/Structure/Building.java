package src.entities.Structure;

import java.awt.Graphics;
import src.Handler;

public class Building extends Structure {

	public Building(Handler han, float x, float y, int w, int he, int h, int mh, int l, String n) {
		super(han, x, y, w, he, 100000, 100000, 30, n);
	}
	@Override
	public void tick(){}

	@Override
	public void render(Graphics g){}

}
