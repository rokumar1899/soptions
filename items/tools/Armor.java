package sOption.items.tools;

import java.awt.image.BufferedImage;

import sOption.Connector;
import sOption.gfx.ImageLoader;
import sOption.items.Item;

public class Armor extends Item {

	private static int leatherHealth;
	private static int woodHealth;
	
	private static int leatherCount;
	private static int woodCount;
	
	public Armor(Connector connector) {
		super(ImageLoader.loadImage("/Regions/Beach.png"), "armor", 7, connector);
		leatherHealth = 40;
		woodHealth = 80;
		leatherCount = 0;
		woodCount = 0;
	}
	
	public static void craftLeather(){	
		leatherCount++;
	}
	
	public static void craftWood(){
		woodCount++;
	}
	
	public static void hitLeather(int damage){
		if(leatherCount==0)
			
			return;
		leatherHealth -= damage;
		if(leatherHealth <= 0){
			leatherHealth = 40;
			leatherCount--;
		}
	}
	
	public static void hitWood(int damage){
		
	}
	
	public static int leatherHealth() {
		return leatherHealth;
	}

	public static int woodHealth() {
		return woodHealth;
	}

	public static int leatherCount(){
		return leatherCount;
	}
	
	public static int woodCount(){
		return woodCount;
	}
}
