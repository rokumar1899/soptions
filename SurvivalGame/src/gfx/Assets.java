package src.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] player_attack, player_shoot;
	public static BufferedImage[] NPC_down, NPC_up, NPC_left, NPC_right;
	public static BufferedImage[] safe_space;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;

	public static void init(){
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		wood = sheet.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);
		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		
		NPC_down = new BufferedImage[2];
		NPC_up = new BufferedImage[2];
		NPC_left = new BufferedImage[2];
		NPC_right = new BufferedImage[2];
		
		NPC_down[0] = sheet.crop(width * 4, height * 2, width, height);
		NPC_down[1] = sheet.crop(width * 5, height * 2, width, height);
		NPC_up[0] = sheet.crop(width * 6, height * 2, width, height);
		NPC_up[1] = sheet.crop(width * 7, height * 2, width, height);
		NPC_right[0] = sheet.crop(width * 4, height * 3, width, height);
		NPC_right[1] = sheet.crop(width * 5, height * 3, width, height);
		NPC_left[0] = sheet.crop(width * 6, height * 3, width, height);
		NPC_left[1] = sheet.crop(width * 7, height * 3, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height * 2);
		rock = sheet.crop(0, height * 2, width, height);
		//safe_space = sheet.crop(0, height * 2, width, height);
	}
	
}
