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
    private int price;
    
    public boolean buyok()
    {
        if(((GameWorld)getWorld()).Money() >= price)
        {
            removetemps();
            return true;
        } else {
            return false;
        }
    }
    
    public void setprice(int cost)
    {
        price = cost;
    }
    
    public int getprice()
    {
        return price;
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
