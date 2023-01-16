import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButNextWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButNextWave extends Button
{
    public ButNextWave()
    {
        GreenfootImage image = new GreenfootImage("buttonNextWave.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("Space"))
        {
            ((GameWorld)getWorld()).nextRound();
        }
    }
}
