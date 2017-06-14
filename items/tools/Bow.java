package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;
import sOption.items.resources.Leaf;
import sOption.items.resources.Stone;
import sOption.items.resources.Wood;

public class Bow extends Item {

	private static int bowCount;
	private static int durable;
	private static int weight;
	
	public Bow(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "bow", 10, connector);
	}
	
	public void shoot(){
		
	}
	
	public static void craft(){
		if(Wood.getCount()<=10){
			System.out.println("you don't have enough material for a bow");
			System.out.println("you need 10 wood");
			return;
		}
		Wood.useSome(10);
		bowCount++;
	}

}
