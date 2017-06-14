package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Meat extends Item {

	public Meat(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png") , "meat", 5, connector);
	}
	
	private static int count;
	
	public static void getMore(int more){	
		count += more;
	}
	
	public static void useSome(int less){
		if(less > count){
			System.out.println("you don't have enough meat");
			return;
		}
		count -= less;
	}
	
	public static int getCount(){
		return count;
	}
	
}
