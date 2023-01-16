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
    
    private Range personalRange = null;
    private boolean mouseOver = false;
    
    public TowerManu()
    {
        range = 600;
        dmg = 2;
        shootingspeed = 10;
       
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
        getWorld().addObject(new Bullet(dmg, range, (this.getRotation()-90)), this.getX(), this.getY());
        shootdelay = shootingspeed;
    }
    
    public void turntomous()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           this.turnTowards(mouse.getX(), mouse.getY());
           this.turn(90);
        }
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
