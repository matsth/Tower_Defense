import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemys extends Actor
{
    private int movementspeed;
    private int health;
    
    private int damage;
    private int value;
    
    /**
     * Setzt die Stats von einem Enemy.
     */
    public void setStats(int[] stats)
    {
        movementspeed = stats[0];
        health = stats[1];
        
        damage = stats[2];
        value = stats[3];
    }
    
    /**
     * Gibt zurück wie schnell ein Gegner ist.
     */
    public int getmove()
    {
        return movementspeed;
    }
    
    /**
     * Test ob das Ende ereicht wurden.
     * Falls ja werden Leben abgezogen mit der changeLifes() Methode der Welt.
     * Danach wird der Enemy entfernt.
     */
    public void touchEnd()
    {
        if(this.isTouching(End.class))
        {
            ((GameWorld)getWorld()).changeLifes(damage);
            
            getWorld().removeObject(this);
        }
    }
    /**
     * Wird verwendet um das Leben eines Enemy abzuziehen.
     * Falls das Leben 0 erreicht wird der Enemy zerstört und gibt sein value als Geld mit der changeMoney() Methode der Welt.
     */
    public void removeLife(int hit)
    {
        health -= hit;
        
        if(health <= 0)
        {
            ((GameWorld)getWorld()).changeMoney(value);
            getWorld().removeObject(this);
        }
    }
}
