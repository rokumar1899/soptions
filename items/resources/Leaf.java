package sOption.items.resources;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Leaf extends Item {

	public Leaf(Connector connector){
		super(ImageLoader.loadImage("/Regions/Beach.png"), "leaf", 3, connector);
	}
	
	private static int leafCount;
	
	public static void getMore(int more){	
		leafCount += more;
	}
	
	public static void useSome(int less){
		if(less > leafCount){
			System.out.println("you don't have enough leaves");
			return;
		}
		leafCount -= less;
	}
	
	public static int getCount(){
		return leafCount;
	}
	
}
