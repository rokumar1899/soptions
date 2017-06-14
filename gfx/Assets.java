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
		SpriteSheet goat = new SpriteSheet(ImageLoader.loadImage("/Unit/Goat.png"));
		SpriteSheet bear = new SpriteSheet(ImageLoader.loadImage("/Unit/Bear.png"));
		SpriteSheet rabbit = new SpriteSheet(ImageLoader.loadImage("/Unit/Rabbit.png"));
		SpriteSheet boar = new SpriteSheet(ImageLoader.loadImage("/Unit/Boar.png"));
	
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
		
		goat_down = new BufferedImage[4];
		goat_down[0] = goat.crop(0, 256, 128, 128);
		goat_down[1] = goat.crop(128, 256, 128, 128);
		goat_down[2] = goat.crop(256, 256, 128, 128);
		goat_down[3] = goat.crop(384, 256, 128, 128);
		
		goat_up = new BufferedImage[4];
		goat_up[0] = goat.crop(0, 0, 128, 128);
		goat_up[1] = goat.crop(128, 0, 128, 128);
		goat_up[2] = goat.crop(256, 0, 128, 128);
		goat_up[3] = goat.crop(384, 0, 128, 128);
		
		goat_left = new BufferedImage[4];
		goat_left[0] = goat.crop(0, 128, 128, 128);
		goat_left[1] = goat.crop(128, 128, 128, 128);
		goat_left[2] = goat.crop(256, 128, 128, 128);
		goat_left[3] = goat.crop(384, 128, 128, 128);
		
		goat_right = new BufferedImage[4];
		goat_right[0] = goat.crop(0, 384, 128, 128);
		goat_up[1] = goat.crop(128, 384, 128, 128);
		goat_up[2] = goat.crop(256, 384, 128, 128);
		goat_up[3] = goat.crop(384, 384, 128, 128);
		
		beach = (new SpriteSheet(ImageLoader.loadImage("/Regions/Beach.png"))).crop(0, 0, 10000, 8000);
	
	}
}
