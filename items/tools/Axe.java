package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;
import sOption.items.resources.Stone;
import sOption.items.resources.Wood;

public class Axe extends Item {

	private static int durable = 20;
	private static int axeCount = 20;
	
	public static int getDurable() {
		return durable;
	}

	public static int getAxeCount() {
		return axeCount;
	}

	public Axe(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "axe", 9, connector);
	}
	
	public static void craftNew(){
		if(Wood.getCount()<=3 || Stone.getCount()<=3){
			System.out.println("you don't have enough material for an axe");
			System.out.println("you need 3 wood and 3 stones");
			return;
		}
		Wood.useSome(3);
		Stone.useSome(3);
		axeCount++;
	}
	
	public static void swing(){
		durable--;
		if(durable==0){
			durable = 20;
			axeCount--;
		}
	}

}
