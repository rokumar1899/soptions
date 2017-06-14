package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Stone extends Item {

	public Stone(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "stone", 5, connector);
	}
	
	private static int count;
	
	public static void getMore(int more){	
		count += more;
	}
	
	public static void useSome(int less){
		if(less > count){
			System.out.println("you don't have enough stones");
			return;
		}
		count -= less;
	}
	
	public static int getCount(){
		return count;
	}

}
