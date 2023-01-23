import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Der Endscreen wird angezeigt wen ein Spiel gewonnen oder verloren wurde.
 * 
 * @author Matteo 
 */
public class EndScreen extends World
{
    private boolean win;
    private int level;
    private int wave;
    private int time;
    
    /**
     * Erstellt das das EndScreen object.
     * Setzt ob gewonnen wude und welches Level gespielt wurde.
     */
    public EndScreen(boolean victory, int templevel, int temptime, int tempwave)
    {    
        super(1200, 780, 1);
        
        win = victory;
        level = templevel;
        wave = tempwave;
        time = temptime;
        
        prepare();
    }
    /**
     * Standard Constructor der verwendet wird um den Endscreen zu testen.
     */
    public EndScreen()
    {    
        super(1200, 780, 1);
        
        win = true;
        level = 1;
        wave = 1;
        time = 1;
        
        prepare();
    }
    
    /**
     * Bereitet den EndScreen vor.
     * Setze entsprechendes Bild ob gewoonen wurde oder nicht.
     * Setzt den Gewonnen Leveltext und passt die Bezwingten Wellen an falls verloren wurde.
     * 
     * Zeigt den entsprechenden Text an.
     */
    private void prepare()
    {
        GreenfootImage image = null;
        String winText = "";
        
        if(win)
        {
            image = new GreenfootImage("WinScreen.png");
            winText = "Glückwunsch du hast Level " + level + " geschaft!";
        } else 
        {
            image = new GreenfootImage("LooseScreen.png");
            winText = "Schade du hast Level " + level + " nicht geschaft!";
            wave -= 1;
        }
        this.addObject(new Attributes(winText), getWidth()/2, getHeight()/2 - 20);
        this.addObject(new Attributes("Das Spiel hat " + time + "s gedauert."), getWidth()/2, getHeight()/2);
        this.addObject(new Attributes("Du hast " + wave + " Wellen bezwungen."), getWidth()/2, getHeight()/2 + 20);
        this.addObject(new Attributes("Drücke ESC um zur Startseite zurückzukehren."), getWidth()/2, getHeight()/2 + 40);
        this.setBackground(image);
    }
    /**
     * Testet ob ESC gedrückt wurde.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("Escape"))
        {
            startscreen();
        }
    }
    /**
     * Erstellt den neuen Startscreen und wechselt die Welt auf diesen.
     */
    private void startscreen()
    {
        StartScreen start = new StartScreen();
        Greenfoot.setWorld(start);
    }
}
