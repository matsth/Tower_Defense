import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class BuyButtonManuelTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyButtonManuelTower extends Button
{
    public BuyButtonManuelTower()
    {
        GreenfootImage image = new GreenfootImage("buttonManuelTower.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
        setprice(300);
    }
    
    /**
     * Act - do whatever the BuyButtonAutoTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        cklicked();
    }
    
    private void cklicked()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("2"))
        {
            if(buyok())
            {
                addTower();
            }
        }
    }
    
    private void addTower()
    {
          Towers towertemp = new TowerManu();
          
          TempTower newtemp = new TempTower(getprice(), towertemp, "TowerManu");
          getWorld().addObject(newtemp, this.getX(), this.getY());
    }
}
