import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Range here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Range extends Actor
{
    private int range;
    
    /**
     * Erzeuge einen bestimte Range mit mitgegeben Radius mit einer Bestimmten Farbe.
     */
    public Range(int size, boolean ok)
    {
        range = size;
        
        changeColor(ok);
    }
    
    /**
     * Ein grüne Range wird mit einem variablen Radius wird erstellt.
     */
    public Range(int size)
    {
        range = size;
        
        changeColor(true);
    }
    
    /**
     * Einen grüner Range mit einem Radius von 150 wird erstellt.
     */
    public Range()
    {
        range = 150;
        
        changeColor(true);
    }
    
    /**
     * Die Farbe des Radius kann auf rot oder grün geändert werden.
     * true ist grün
     * fals ist rot
     */
    public void changeColor(boolean ok)
    {
        GreenfootImage image = null;
        
        if(ok)
        {
            
            image = new GreenfootImage("Rangegood.png");
            
        } else {
            
            image = new GreenfootImage("Rangebad.png");
            
        }
        
        image.scale(range*2, range*2);
        setImage(image);
    }
}
