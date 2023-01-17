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
    
    public void setStats(int[] stats)
    {
        movementspeed = stats[0];
        health = stats[1];
        
        damage = stats[2];
        value = stats[3];
    }
    
    public int getmove()
    {
        return movementspeed;
    }
    
    public void touchEnd()
    {
        if(this.isTouching(End.class))
        {
            ((GameWorld)getWorld()).changeLifes(damage);
            
            getWorld().removeObject(this);
        }
    }
    
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
