import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowerManu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerManu extends Towers
{
    private int shootdelay = 0;
    
    public TowerManu()
    {
        int range = 600;
        int dmg = 3;
        int shootingspeed = 10;
        
        setup(new int[]{range, dmg, shootingspeed});
        
        GreenfootImage image = new GreenfootImage("TowerManu.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);
        this.setImage(image);
    }
    /**
     * Act - do whatever the TowerManu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        turntomous();
        hover();
        
        shootdelay--;
        if(shootdelay <= 0)
        {
            shoot();
        }
    }
    
    private void shoot()
    {
        getWorld().addObject(new Bullet(getDmg(), getRange(), (this.getRotation()-90)), this.getX(), this.getY());
        shootdelay = getShootspeed();
    }
    
    public void turntomous()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           this.turnTowards(mouse.getX(), mouse.getY());
           this.turn(90);
        }
    }
}
