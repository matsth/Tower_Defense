import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Dise Methode dient dazu Text anzupssen.
     */
    public void setText(String text)
    {
        GreenfootImage image = null;
        image = new GreenfootImage(text, 20, Color.BLACK, null, null);
        this.setImage(image);
    }
}
