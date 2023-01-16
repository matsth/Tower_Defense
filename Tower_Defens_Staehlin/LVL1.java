import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class LVL1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL1 extends GameWorld
{
    /**
     * Constructor for objects of class LVL1.
     *
     */
    public LVL1()
    {
        //super(1200, 780, 1);
        prepare();
    }
    
    /**
     * Bereitet das Level vor.
     */
    private void prepare()
    {
        cash = 400;
        lifes = 5;
        Level = 1;
        spawnPerWave = new int[]{0, 6, 12, 20, 25, 38, 49};
        spawnoffset = new int[]{0, 40, 20, 30, 25, 18, 8};
        currentspawend = spawnPerWave[currentWave];

        this.addObject(new Attributes("Time: " + timer), getWidth() - getWidth()/15, getHeight()/20);
        this.addObject(new Attributes("Money: " + cash), getWidth() - getWidth()/15, getHeight()/14);
        this.addObject(new Attributes("Lifes: " + lifes), getWidth() - getWidth()/15, getHeight()/11);
        this.addObject(new Attributes("Wave " + (currentWave) + " / " + (spawnPerWave.length - 1)), getWidth() - getWidth()/15, getHeight()/9);
        
        //Ende
        End end = new End();
        this.addObject(end,getWidth() - getWidth()/3 + getWidth()/17, getHeight() - getHeight()/37);

        //Spawner wird nur gebraucht um den spawnpoint zu setzen
        Spawner spawner = new Spawner();
        this.addObject(spawner,getWidth()/4 - getWidth()/25, getHeight()/9);
        this.spawnpoint = new Point(spawner.getX(), spawner.getY());
        this.removeObject(spawner);
        
        ButNextWave butNextWave = new ButNextWave();
        this.addObject(butNextWave,getWidth() - getWidth()/15, getHeight()/5);
        
        //Shop
        BuyButtonAutoTower towerbutton = new BuyButtonAutoTower();
        this.addObject(towerbutton,0 + getWidth()/15, getHeight()/10);
        
        int height = towerbutton.getImage().getHeight();
        
        Price pricenew = new Price(towerbutton.price + "$");
        this.addObject(pricenew,0 + getWidth()/15, getHeight()/10 + height);
        
        BuyButtonManuelTower towerbutton2 = new BuyButtonManuelTower();
        this.addObject(towerbutton2,0 + getWidth()/15, getHeight()/10 + height*2);
        
        Price pricenew2 = new Price(towerbutton2.price + "$");
        this.addObject(pricenew2,0 + getWidth()/15, getHeight()/10 + height*3);
        
        BuyBoom boomButton = new BuyBoom();
        this.addObject(boomButton, 0 + getWidth()/15, getHeight()/10 + + height*4);
        
        Price pricenew3 = new Price(boomButton.price + "$");
        this.addObject(pricenew3,0 + getWidth()/15, getHeight()/10 + height*5);
    }
}
