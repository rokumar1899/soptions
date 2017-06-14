package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;
import sOption.items.resources.Leaf;
import sOption.items.resources.Stone;
import sOption.items.resources.Wood;

public class Arrow extends Item {
	
	private static int arrowCount;
	
	public int getArrowCount() {
		return arrowCount;
	}

	public void setArrowCount(int arrowCount) {
		this.arrowCount = arrowCount;
	}

	public Arrow(Connector connector){
		super(ImageLoader.loadImage("/Regions/Beach.png"), "arrow", 8, connector);
		
	}
	
	public static void craftMore(){
		if(Wood.getCount()==0||Stone.getCount()<=1||Leaf.getCount()==0){
			System.out.println("you don't have enough material for an arrow");
			System.out.println("you need 1 wood, 1 leaf, and 1 stone");
			return;
		}
		Wood.useSome(1);
		Stone.useSome(1);
		Leaf.useSome(1);
		arrowCount++;
	}
	
	public static void shoot(){
		if(arrowCount==0){
			System.out.println("you have no arrows");
			return;
		}
		arrowCount--;
	}
}

