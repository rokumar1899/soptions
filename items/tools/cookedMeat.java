package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;
import sOption.items.resources.Meat;

public class cookedMeat extends Item {
	
	private static int cookedMeatCount;
	
	public cookedMeat(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "cooked meat", 11, connector);
	}

	public static void cookMeat(){
		if(Meat.getCount()==0){
			System.out.println("you don't have any meat");
			return;
		}
		cookedMeatCount += Meat.getCount();
		Meat.useSome(Meat.getCount());
	}
	
	public static void eatSome(int some){
		cookedMeatCount -= some;
	}

}
