import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Dieser Button erstellt einen TempTower mit dem AutoTower vormat.
 * 
 * @author Matteo
 */
public class BuyButtonAutoTower extends Button
{
    /**
     * Der Constructor von BuyButtonAutoTower erstellt den Button und macht diesen kleiner.
     * Zusätzlich wird der Preis noch gesetzt.
     */
    public BuyButtonAutoTower()
    {
        GreenfootImage image = new GreenfootImage("buttonAutoTower.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
        setprice(200);
    }
    
    /**
     * Act - do whatever the BuyButtonAutoTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Testet ob der Button aktiviert wurde.
     */
    public void act()
    {
        cklicked();
    }
    
    /**
     * Testet ob der Button Angeklickt wurde oder der Shortcut verwendet wurde.
     * Danach wird ein TempTower erstellt vom Autotower erstellt.
     */
    private void cklicked()
    {
        if(cklickcheck("1"))
        {
            if(buyok())
            {
                addTower(new TowerAuto(), "TowerAuto");
            }
        }
    }
}
