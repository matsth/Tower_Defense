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
    
    /**
     * Hier wird getestet ob man genügen Geld hat um das entsprechende Item zu Kaufen.
     * Falls ja werden die Templates entfernt und ja zurückgegeben.
     */
    public boolean buyok()
    {
        if(((GameWorld)getWorld()).money() >= price)
        {
            removetemps();
            return true;
        } else {
            return false;
        }
    }
    /**
     * Hier wird der Preis eines Item gesetzt.
     */
    public void setprice(int cost)
    {
        price = cost;
    }
    /**
     * Hier holt sich einer der Buy Buttons sein aktuellen Preis.
     */
    public int getprice()
    {
        return price;
    }
    /**
     * Es wird getestet ob es Momentan Templates oder einen aktiven Spell gibt und falls ja wird dieser mit der eigenen removethis() Methode entfernt.
     */
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
    /**
     * Es wird ein neuer TowerTemplate erstellt.
     */
    public void addTower(Towers towertemp, String towerdescrip)
    {
          TempTower newtemp = new TempTower(price, towertemp, towerdescrip);
          getWorld().addObject(newtemp, this.getX(), this.getY());
    }
}
