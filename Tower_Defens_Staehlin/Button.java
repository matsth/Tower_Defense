import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Hier werden die Standard funktionen des Buttons verwaltet.
 * 
 * Vom Preis bis zum testen ob er gekauft werden kann ist alles hier verwaltet.
 * 
 * @author Matteo
 */
public class Button extends Actor
{
    private int price;
    
    /**
     * Hier wird getestet ob man genügen Geld hat um das entsprechende Item zu Kaufen.
     * Falls ja werden die Templates entfernt und ja zurückgegeben.
     * 
     * @return Gibt zurück ob das Item gekauft werden kann.
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
     * 
     * @param cost setzt der Preis des Items auf den Parameter.
     */
    public void setprice(int cost)
    {
        price = cost;
    }
    /**
     * Hier holt sich einer der Buy Buttons sein aktuellen Preis.
     * 
     * @return Gibt zurück wie teuer das Item ist.
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
     * 
     * @param towertemp ist der Tower der gekauft wird.
     * @param towerdescrip ist der Name des Bilds des Towers der gekauft wird.
     */
    public void addTower(Towers towertemp, String towerdescrip)
    {
          TempTower newtemp = new TempTower(price, towertemp, towerdescrip);
          getWorld().addObject(newtemp, this.getX(), this.getY());
    }
    
    /**
     * Checkt ob der Button oder der Shortcut gedrückt wurde.
     * 
     * @param shortcut ist der auf den getestet wird.
     * @return Gibt zurück ob das Object oder der Shortcut gedrückt wurde.
     */
    public boolean cklickcheck(String shortcut)
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown(shortcut))
        {
            return true;
        } else {
            return false;
        }
    }
}
