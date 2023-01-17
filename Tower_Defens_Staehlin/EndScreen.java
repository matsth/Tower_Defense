import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private boolean win;
    private int level;
    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen(boolean victory, int templevel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 780, 1);
        
        win = victory;
        level = templevel;
        
        prepare();
    }
    /**
     * Bereitet das EndScreen vor.
     */
    private void prepare()
    {
        GreenfootImage image = null;
        
        if(win)
        {
            image = new GreenfootImage("WinScreen.png");            
        } else 
        {
            image = new GreenfootImage("LooseScreen.png");
        }
        this.setBackground(image);
    }
}
