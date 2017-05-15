package wl.worthless.simplegame.gfx;

import java.awt.image.*;


public class Assets
{
    private static BufferedImage brick, dirt, grass, stone, tree, germ1, germ2, bulletR, bulletU, bulletD, bulletL;
    public static BufferedImage[] player_down, player_up, player_left, player_right, germ_move, bulletR_move, bulletU_move, bulletD_move, bulletL_move;
    private static BufferedImage gameOver, rof;
    
    private static final int width = 32, height = 32;
    
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        
        player_down = new BufferedImage[2]; // number represents frame
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];
        germ_move = new BufferedImage[2];
        
        bulletR_move = new BufferedImage[1];
        bulletU_move = new BufferedImage[1];
        bulletL_move = new BufferedImage[1];
        bulletD_move = new BufferedImage[1];
        
        player_down[0] = sheet.crop(width * 4, 0, width, height);
        player_down[1] = sheet.crop(width * 5, 0, width, height);
        
        player_up[0] = sheet.crop(width * 6, 0, width, height);
        player_up[1] = sheet.crop(width * 7, 0, width, height);
        
        player_right[0] = sheet.crop(width * 4, height, width, height);
        player_right[1] = sheet.crop(width * 5, height, width, height);
        
        player_left[0] = sheet.crop(width * 6, height, width, height);
        player_left[1] = sheet.crop(width * 7, height, width, height);
        
        tree = sheet.crop(0, 0, width, height*2);
        dirt = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width*2, 0, width, height);
        stone = sheet.crop(0, height*2, width, height);
        brick = sheet.crop(width*3, 0, width, height);
        
        germ1 = sheet.crop(width, height, width, height);
        germ2 = sheet.crop(width*2, height, width, height);
        
        germ_move[0] = germ1;
        germ_move[1] = germ2;
        
        bulletR = sheet.crop(width*3, height, 8, 5);
        bulletU = sheet.crop(width*3, height+5, 8, 5);
        bulletL = sheet.crop(width*3, height+13, 8, 5);
        bulletD = sheet.crop(width*3, height + 18, 8, 5);
        
        bulletR_move[0] = bulletR;
        bulletL_move[0] = bulletL;
        bulletU_move[0] = bulletU;
        bulletD_move[0] = bulletD;
        
        setGameOver(sheet.crop(width*4, height*4, width*3, height));
        setRof(sheet.crop(width*7, height*4, width, height));
    }
    
    
    public static BufferedImage getBrick()
    {
    	return brick;
    }
    
    public static BufferedImage getGrass()
    {
        return grass;
    }
    
    public static BufferedImage getDirt()
    {
        return dirt;
    }
    
    public static BufferedImage getTree()
    {
        return tree;
    }
    
    public static BufferedImage getStone()
    {
        return stone;
    }
    
    public static BufferedImage getGerm1()
    {
    	return germ1;
    }
    
    public static BufferedImage getGerm2()
    {
    	return germ2;
    }
    
    public static BufferedImage getBulletR()
    {
    	return bulletR;
    }
    
    public static BufferedImage getBulletL()
    {
    	return bulletL;
    }
    
    public static BufferedImage getBulletU()
    {
    	return bulletU;
    }
    
    public static BufferedImage getBulletD()
    {
    	return bulletD;
    }


	public static BufferedImage getGameOver() {
		return gameOver;
	}


	public static void setGameOver(BufferedImage gameOver) {
		Assets.gameOver = gameOver;
	}


	public static BufferedImage getRof() {
		return rof;
	}


	public static void setRof(BufferedImage rof) {
		Assets.rof = rof;
	}
}