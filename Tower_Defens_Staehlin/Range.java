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
    
    public Range(int size, boolean ok)
    {
        range = size;
        
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
    
    public Range(int size)
    {
        range = size;
        
        GreenfootImage image = new GreenfootImage("Rangegood.png");
        
        image.scale(range*2, range*2);
        setImage(image);
    }
    
    public Range()
    {
        range = 150;
        
        GreenfootImage image = new GreenfootImage("Rangegood.png");
        image.scale(range*2, range*2);
        setImage(image);
    }
    
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
