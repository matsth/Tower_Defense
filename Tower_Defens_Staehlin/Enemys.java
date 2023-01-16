import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemys extends Actor
{
    public int movementspeed;
    public int health;
    
    public int damage;
    public int value;
    
    public void touchEnd()
    {
        if(this.isTouching(End.class))
        {
            ((GameWorld)getWorld()).changeLifes(damage);
            
            getWorld().removeObject(this);
        }
    }
    
    public int testBullet()
    {
        Bullet bul = (Bullet)getOneIntersectingObject(Bullet.class);
        
        if(bul != null)
        {
            int x = bul.dmg;
            
            getWorld().removeObject(bul);
            
            return x;
        }
        return 0;
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
