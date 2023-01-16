import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BuyButtonAutoTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyButtonAutoTower extends Button
{
    public BuyButtonAutoTower()
    {
        GreenfootImage image = new GreenfootImage("buttonAutoTower.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
        price = 200;
    }
    
    /**
     * Act - do whatever the BuyButtonAutoTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        cklicked();
    }
    
    public void cklicked()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("1"))
        {
            if(buyok())
            {
                addTower();
            }
        }
    }
    
    public void addTower()
    {
          Towers towertemp = new TowerAuto();
          
          TempTower newtemp = new TempTower(price, towertemp, "TowerAuto");
          getWorld().addObject(newtemp, this.getX(), this.getY());
    }
}
