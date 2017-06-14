package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Fur extends Item {
	
	public Fur(Connector connector){
		super(ImageLoader.loadImage("/Regions/Beach.png"), "fur", 2, connector);
	}
	
	private static int furCount;
	
	public static void getMore(int more){	
		furCount += more;
	}
	
	public static void useSome(int less){
		if(less > furCount){
			System.out.println("you don't have enough fur");
			return;
		}
		furCount -= less;
	}
	
	public static int getCount(){
		return furCount;
	}

}
