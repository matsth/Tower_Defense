import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends Actor
{
    private int range;
    private int dmg;
    private int shootingspeed;
    
    private Range personalRange = null;
    private boolean mouseOver = false;
    
    public void setup(int[] stats)
    {
        range = stats[0];
        dmg = stats[1];
        shootingspeed = stats[2];
    }
    
    public int getRange()
    {
        return range;
    }
    
    public int getDmg()
    {
        return dmg;
    }
    
    public int getShootspeed()
    {
        return shootingspeed;
    }
    
    public Enemys findEnemy()
    {
        List<Enemys> enemy = getObjectsInRange(range, Enemys.class);
        
        if(enemy.isEmpty())
        {
            return null;
        } else
        {
            return (enemy.get(0));
        }
    }
    
    public void hover()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            personalRange = new Range(getRange(),true);
            getWorld().addObject(personalRange, this.getX(), this.getY());
            
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))
        {
            getWorld().removeObject(personalRange);
            
            mouseOver = false;
        }
    }
}
