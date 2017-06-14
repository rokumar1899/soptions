package sOption.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 32, height = 32;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] goat_down, goat_up, goat_left, goat_right;
	public static BufferedImage[] bear_down, bear_up, bear_left, bear_right;
	public static BufferedImage[] rabbit_down, rabbit_up, rabbit_left, rabbit_right;
	public static BufferedImage[] boar_down, boar_up, boar_left, boar_right;
	public static BufferedImage beach, river, plain, forest, mountain, village;
	
	public static void init()
	{
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
		SpriteSheet goat = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
		SpriteSheet bear = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
		SpriteSheet rabbit = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
		SpriteSheet boar = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
	
		player_down = new BufferedImage[4];
		player_down[0] = player.crop(0, 512, 256, 512);
		player_down[1] = player.crop(256, 512, 256, 512);
		player_down[2] = player.crop(512, 512, 256, 512);
		player_down[3] = player.crop(768, 512, 256, 512);
		
		player_up = new BufferedImage[4];
		player_up[0] = player.crop(0, 0, 256, 512);
		player_up[1] = player.crop(256, 0, 256, 512);
		player_up[2] = player.crop(512, 0, 256, 512);
		player_up[3] = player.crop(768, 0, 256, 512);
		
		player_left = new BufferedImage[4];
		player_left[0] = player.crop(0, 1024, 256, 512);
		player_left[1] = player.crop(256, 1024, 256, 512);
		player_left[2] = player.crop(512, 1024, 256, 512);
		player_left[3] = player.crop(768, 1024, 256, 512);
		
		player_right = new BufferedImage[4];
		player_right[0] = player.crop(0, 1536, 256, 512);
		player_right[1] = player.crop(256, 1536, 256, 512);
		player_right[2] = player.crop(512, 1536, 256, 512);
		player_right[3] = player.crop(768, 1536, 256, 512);
		
		
		beach = (new SpriteSheet(ImageLoader.loadImage("/Regions/Beach.png"))).crop(0, 0, 10000, 8000);
	
	}
}
