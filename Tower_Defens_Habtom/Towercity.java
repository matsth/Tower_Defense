import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towercity extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Towercity()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        PathMap();

    }
    
    public void PathMap()
    {
        GreenfootImage image = new GreenfootImage("Path_Red.png");
        //image.scale(image.getWidth(), image.getHeight()/3);
        this.setBackground(image);
        
    }
    
}
