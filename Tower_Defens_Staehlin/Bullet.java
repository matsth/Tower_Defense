import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public int dmg;
    private int speed;
    
    private boolean auto;
    private Enemys target;
    
    
    public Bullet()
    {
        
    }
    public Bullet(int dmgtemp, Enemys targettemp)
    {
        dmg = dmgtemp;
        speed = 8;
        auto = true;
        target = targettemp;
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(auto)
        {
            if(target.getWorld() == null)
            {
                getWorld().removeObject(this);
            } else {
                moveauto();
            }
        }
    }
    
    private void moveauto()
    {
        int X = this.getX() - target.getX();
        int Y = this.getY() - target.getY();
        
        if(X > 0)
        {
            if(X > speed)
            {
                X = speed;
            }
        } else if (X < 0)
        {
            if(X < -speed)
            {
                X = -speed;
            }
        }
        if(Y > 0)
        {
            if(Y > speed)
            {
                Y = speed;
            }
        } else if (Y < 0)
        {
            if(Y < -speed)
            {
                Y = -speed;
            }
        }
        
        this.setLocation(this.getX()-X, this.getY()-Y);
    }
}
