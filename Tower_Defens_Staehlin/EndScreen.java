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
     * Erstellt das das EndScreen object.
     * Setzt ob gewonnen wude und welches Level gespielt wurde.
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
     * Bereitet den EndScreen vor.
     * Setze entsprechendes Bild ob gewoonen wurde oder nicht.
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
