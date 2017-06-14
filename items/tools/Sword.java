package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;
import sOption.items.resources.Wood;

public class Sword extends Item {
	
	private static int swordCount = 0;
	private static int durable = 20;;
	
	public Sword(Connector connector){
		super(ImageLoader.loadImage("/Regions/Beach.png"), "sword", 12, connector);
	}
	
	public static void craftNew(){
		if(Wood.getCount()<=10){
			System.out.println("you don't have enough material for a sword");
			System.out.println("you need 10 wood");
			return;
		}
		Wood.useSome(10);
		swordCount++;
	}
	
	public static void swing(){
		durable--;
		if(durable==0){
			durable = 20;
			swordCount--;
		}
	}
	
}
