package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Chest extends Item {

	public Chest(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "chest", 0, connector);
	}
	
	

}
