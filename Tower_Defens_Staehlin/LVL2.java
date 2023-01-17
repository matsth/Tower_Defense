import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class LVL2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL2 extends GameWorld
{
    /**
     * Constructor for objects of class LVL2.
     *
     */
    public LVL2()
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
        Level = 2;
        spawnPerWave = new int[]{0, 6, 12, 20, 25, 38, 49};
        spawnoffset = new int[]{0, 40, 20, 30, 25, 18, 8};
        currentspawend = spawnPerWave[currentWave];

        this.addObject(new Attributes("Time: " + timer), this.getWidth() - this.getWidth()/15, this.getHeight()/20);
        this.addObject(new Attributes("Money: " + cash + "$"), this.getWidth() - this.getWidth()/15, this.getHeight()/14);
        this.addObject(new Attributes("Lifes: " + lifes), this.getWidth() - this.getWidth()/15, this.getHeight()/11);
        this.addObject(new Attributes("Wave " + (currentWave) + " / " + (spawnPerWave.length - 1)), this.getWidth() - this.getWidth()/15, this.getHeight()/9);
        
        //Ende
        End end = new End();
        this.addObject(end,0 + this.getWidth()/3 + this.getWidth()/17, 0 + this.getHeight()/37);

        //Spawner wird nur gebraucht um den spawnpoint zu setzen
        Spawner spawner = new Spawner();
        this.addObject(spawner,this.getWidth() - this.getWidth()/3 - this.getWidth()/15, this.getHeight() - this.getHeight()/13);
        this.spawnpoint = new Point(spawner.getX(), spawner.getY());
        this.removeObject(spawner);
        
        
        //Wave start Button
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
