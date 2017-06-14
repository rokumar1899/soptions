package sOption.items.resources;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Fruit extends Item {
	
	public Fruit(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "fruit", 1, connector);
	}
	
	private static int fruitCount;
	
	public static void getMore(int more){	
		fruitCount += more;
	}
	
	public static void eatSome(int less){
		if(less > fruitCount){
			System.out.println("you don't have enough fruit");
			return;
		}
		fruitCount -= less;
	}
	
	public static int getCount(){
		return fruitCount;
	}
	
}
