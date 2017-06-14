package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Log extends Item {

	public Log(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "log", 4, connector);
	}
	
	private static int count;
	
	public static void getMore(int more){	
		count += more;
	}
	
	public static void useSome(int less){
		if(less > count){
			System.out.println("you don't have enough wood");
			return;
		}
		count -= less;
	}
	
	public static int getCount(){
		return count;
	}

}
