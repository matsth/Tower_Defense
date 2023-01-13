import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Range here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Range extends Actor
{
    public Range(int size, boolean ok)
    {
        GreenfootImage image = null;
        
        if(ok)
        {
            
            image = new GreenfootImage("Rangegood.png");
            
        } else {
            
            image = new GreenfootImage("Rangebad.png");
            
        }
        
        image.scale(size*2, size*2);
        setImage(image);
    }
    
    public Range()
    {
        GreenfootImage image = new GreenfootImage("Rangegood.png");
        image.scale(300, 300);
        setImage(image);
    }
}
