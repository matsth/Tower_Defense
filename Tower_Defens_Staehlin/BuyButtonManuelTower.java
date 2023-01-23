import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Dieser Button erstellt einen TempTower mit dem ManuTower vormat.
 * 
 * @author Matteo
 */
public class BuyButtonManuelTower extends Button
{
    /**
     * Der Constructor von BuyButtonManuelTower erstellt den Button und macht diesen kleiner.
     * Zusätzlich wird der Preis noch gesetzt.
     */
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
     * 
     * Testet ob der Button aktiviert wurde.
     */
    public void act()
    {
        cklicked();
    }
    /**
     * Testet ob der Button Angeklickt wurde oder der Shortcut verwendet wurde.
     * Danach wird ein TempTower erstellt vom TowerManu erstellt.
     */
    private void cklicked()
    {
        if(cklickcheck("2"))
        {
            if(buyok())
            {
                addTower(new TowerManu(), "TowerManu");
            }
        }
    }
}
