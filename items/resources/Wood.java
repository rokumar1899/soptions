package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Wood extends Item {
	
	public Wood(Connector connector){
		super(ImageLoader.loadImage("/Regions/Beach.png"), "wood", 6, connector);
	}
	
	private static int woodCount = 0;
	
	public static void getMore(int more){	
		woodCount += more;
	}
	
	public static void useSome(int less){
		if(less > woodCount){
			System.out.println("you don't have enough wood");
			return;
		}
		woodCount -= less;
	}
	
	public static int getCount(){
		return woodCount;
	}

}
