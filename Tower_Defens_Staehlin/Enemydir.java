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
        movementspeed = 1;
        health = 10;
        damage = 2;
        value = 20;
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
        this.move(movementspeed);
        touchEnd();
    }
    
    private void setGoeal()
    {
        List<End> goal = getWorld().getObjects(End.class);
        target = new Point(goal.get(0).getX(), goal.get(0).getY()); 
        goalset = true;
    }
}
