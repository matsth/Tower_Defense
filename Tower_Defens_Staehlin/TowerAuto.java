import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerAuto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerAuto extends Towers
{
    private int shootdelay = 0;
    
    private Range personalRange = null;
    private boolean mouseOver = false;
    
    private Enemys currenttarget = null;
    
    public TowerAuto()
    {
        range = 150;
        dmg = 5;
        shootingspeed = 40;
       
        GreenfootImage image = new GreenfootImage("TowerAuto.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
    }
    
    /**
     * Act - do whatever the TowerAuto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        hover();
        
        currenttarget = findEnemy();
        
        shootdelay--;
        if(currenttarget != null && shootdelay <= 0)
        {
            shoot();
        }
    }
    
    public void shoot()
    {
        this.turnTowards(currenttarget.getX(), currenttarget.getY());
        this.turn(90);
        
        getWorld().addObject(new Bullet(dmg, currenttarget), this.getX(), this.getY());
        shootdelay = shootingspeed;
    }
    
    public void hover()
    {
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            personalRange = new Range(range,true);
            getWorld().addObject(personalRange, this.getX(), this.getY());
            
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))
        {
            getWorld().removeObject(personalRange);
            
            mouseOver = false;
        }
    }
}
