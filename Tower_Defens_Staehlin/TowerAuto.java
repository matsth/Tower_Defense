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
    
    private Enemys currenttarget = null;
    
    public TowerAuto()
    {
        int range = 150;
        int dmg = 5;
        int shootingspeed = 40;
        
        setup(new int[]{range, dmg, shootingspeed});
        
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
    
    private void shoot()
    {
        this.turnTowards(currenttarget.getX(), currenttarget.getY());
        this.turn(90);
        
        getWorld().addObject(new Bullet(getDmg(), currenttarget), this.getX(), this.getY());
        shootdelay = getShootspeed();
    }
}
