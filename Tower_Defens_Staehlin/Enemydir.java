import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemydir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemydir extends Enemys
{
    private Point target;
    private boolean goalset = false;
    
    public Enemydir()
    {
        int movementspeed = 1;
        int health = 10;
        int damage = 2;
        int value = 20;
        
        setStats(new int[]{movementspeed, health, damage, value});
    }
    /**
     * Act - do whatever the Enemydir wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!goalset)
        {
            setGoeal();
        }
        this.turnTowards(target.getX(), target.getY());
        this.move(getmove());
        touchEnd();
    }
    
    private void setGoeal()
    {
        List<End> goal = getWorld().getObjects(End.class);
        target = new Point(goal.get(0).getX(), goal.get(0).getY()); 
        goalset = true;
    }
}
