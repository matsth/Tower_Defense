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
    
    /**
     * Setzt die statistik dieses Gegners.
     */
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
     * 
     * Falls noch keine Koordinaten des Endes vorhanden sind führe die ssetGoeal() Methode aus.
     * Danach Bewegt sich dieser Enemy und führt die touchEnd() Methode aus.
     */
    public void act()
    {
        if(!goalset)
        {
            setGoeal();
        }
        move();
        touchEnd();
    }
    
    /**
     * Dreht sich zum gesetzten Goal und bewegt sich dort hin mit seiner Geschwindigkeit.
     */
    private void move()
    {
        this.turnTowards(target.getX(), target.getY());
        this.move(getmove());
    }
    
    /**
     * Holt sich die Kordinaten des Endes.
     * Erzeugt einen neuen Point mit diesen Kordinaten.
     */
    private void setGoeal()
    {
        List<End> goal = getWorld().getObjects(End.class);
        target = new Point(goal.get(0).getX(), goal.get(0).getY()); 
        goalset = true;
    }
}
