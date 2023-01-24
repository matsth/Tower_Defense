import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Vom Startscreen aus kann man mit 1 oder 2 auswählen welche Runde gespielt werden soll.
 * Zusätzlich hat es auf dem Bild noch eine Spielanleitung.
 * 
 * @author Matteo
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * Setzt die grösse des Screens.
     */
    public StartScreen()
    {    
        super(1200, 780, 1);
    }
    /**
     * Testet welches Level gespielt werden möchte.
     */
    public void act(){
        if(Greenfoot.isKeyDown("1"))
        {
            setWorld(1);
        } else if(Greenfoot.isKeyDown("2"))
        {
            setWorld(2);
        }
    }
    /**
     * Erstelt das Level und ändert auf das Level.
     * 
     * @param Levelnumber ist die Nummer des Levels das aufgerufen werden soll.
     */
    private void setWorld(int Levelnumber)
    {
        GameWorld Level = null;
        
        switch(Levelnumber) {
            case 1:
                Level = new LVL1();
                break;
            case 2:
                Level = new LVL2();
                break;
        }
        
        Greenfoot.setWorld(Level);
    }
}
