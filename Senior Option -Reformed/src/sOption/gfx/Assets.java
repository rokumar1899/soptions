package sOption.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static SpriteSheet beach, river, plain, forest, mountain, village;
	
	public static void init()
	{
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/Unit/Player.png"));
	
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
		
		
		beach = new SpriteSheet(ImageLoader.loadImage("/Regions/Beach.png"));
	}
}
