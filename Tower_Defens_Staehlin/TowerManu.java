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
    
    /**
     * Setzt die Stats des Towers und Passt die grösse des Objects an.
     */
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
     * 
     * Zuerst dreht sich der Turm zur Maus.
     * Danach wird getestet ob über den Tower gehoved wird.
     * Danach wird der shotdelay Reduziert.
     * 
     * Falls der shootdelay unter gleich 0 ist wird geschossen.
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
    
    /**
     * Eine neue Manuelle Bullet wird erzeugt mit der ausrichtung dieses Towers.
     * Danach wird der shootdelay neu gesetzt.
     */
    private void shoot()
    {
        getWorld().addObject(new Bullet(getDmg(), getRange(), (this.getRotation()-90)), this.getX(), this.getY());
        shootdelay = getShootspeed();
    }
    /**
     * Falls die Maus in der Welt ist dreht sich der Turm zur Maus.
     * Er dreht sich nochmals 90 Grad damit das Bild richtig ausieht.
     */
    public void turntomous()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           this.turnTowards(mouse.getX(), mouse.getY());
           this.turn(90);
        }
    }
}
