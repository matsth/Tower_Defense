import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemys extends Actor
{
    public void touchEnd(int dmg)
    {
        if(this.isTouching(End.class))
        {
            ((GameWorld)getWorld()).lifechange += -dmg;
            
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
}
