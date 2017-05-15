package wl.worthless.simplegame.gfx;

import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class ImageLoader
{
    public static BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("this is reason");
            //System.exit(1);
        }
        return null;
    }
}
