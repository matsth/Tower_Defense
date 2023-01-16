import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public int price;
    public Towers tower;
    public String towername;
    
    public boolean buyok()
    {
        if(((GameWorld)getWorld()).cash >= price)
        {
            removetemps();
            return true;
        } else {
            return false;
        }
    }
    
    public void removetemps()
    {
        List<TempTower> temps = getWorld().getObjects(TempTower.class);
        List<Spells> spells = getWorld().getObjects(Spells.class);
        
        if(!temps.isEmpty())
        {
            temps.forEach(temp -> temp.removethis());
        }
        if(!spells.isEmpty())
        {
            spells.forEach(spell -> spell.removethis());
        }
    }
}
