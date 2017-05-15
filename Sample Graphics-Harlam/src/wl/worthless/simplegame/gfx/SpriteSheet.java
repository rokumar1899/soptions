package wl.worthless.simplegame.gfx;

import java.awt.image.*;

public class SpriteSheet
{
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sht)
    {
        sheet = sht;
    }

    public BufferedImage crop(int x, int y, int width, int height)
    {
        return sheet.getSubimage(x, y, width, height);
    }
}