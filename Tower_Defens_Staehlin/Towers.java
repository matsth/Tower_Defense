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
    
    /**
     * Die Stats des Towers werden Gesetzt.
     */
    public void setup(int[] stats)
    {
        range = stats[0];
        dmg = stats[1];
        shootingspeed = stats[2];
    }
    /**
     * Gibt die Range des Towers aus.
     */
    public int getRange()
    {
        return range;
    }
    /**
     * Gibt den Schaden des Towers aus.
     */
    public int getDmg()
    {
        return dmg;
    }
    /**
     * Gibt den Reloadspeed des Towers aus.
     */
    public int getShootspeed()
    {
        return shootingspeed;
    }
    
    /**
     * Findet alle Gegner inerhalb der Reichweite des Towers zurück und holt den ersten raus.
     */
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
    /**
     * Falls über den Tower gehoverd wird erstellt dieser ein neues Range Object mit der Range des Towers.
     * Falls nichtmer über den Tower gehoverd wird die Range entfernt.
     */
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
