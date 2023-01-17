import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boom extends Spells
{
    private int dmg = 100;
    
    public Boom(int tempprice, int tempsize)
    {
        setRange(tempsize);
        setprice(tempprice);
        
        this.setText("BOOM!");
    }
    /**
     * Act - do whatever the Boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        addspellrange();
        followMous();
        buythis();
        stop();
    }
    
    public void buythis()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(returnRangeobj()))
        {
            ((GameWorld)getWorld()).changeMoney(-getprice());
            List<Enemys> targets = getObjectsInRange(returnRange(), Enemys.class);
            
            if(!targets.isEmpty())
            {
                targets.forEach(target -> target.removeLife(dmg));
            }
            removethis();
        }
    }
}
