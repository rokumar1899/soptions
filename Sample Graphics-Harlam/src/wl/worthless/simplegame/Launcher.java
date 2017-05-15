package wl.worthless.simplegame; 

public class Launcher
{
    public static void main(String[] args)
    {
        Game game = new Game("CESCO Game", 1040, 720);
        game.start();
    }
}