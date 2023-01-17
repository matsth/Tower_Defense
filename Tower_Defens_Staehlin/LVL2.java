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
     * Setzt das Level auf.
     */
    public LVL2()
    {
        //super(1200, 780, 1);
        prepare();
    }
    
    /**
     * Ein Spawner wird erzeugt (nur um visuel zu schauen wo der Spawnpoint ist) ind diese Kordinaten werden dem Point gegeben.
     * Es werden die Grössen der Gegnerwellen und die Spawntime dieser bestimmt.
     * Danach werden die Spielartribute in die GameWorld geschrieben.
     * 
     * Das Ende wird plaziert und der NextWave Button
     * Danach wird der Shop erzeugt.
     */
    private void prepare()
    {
        //Spawner wird nur gebraucht um den spawnpoint zu setzen
        Spawner spawner = new Spawner();
        this.addObject(spawner,this.getWidth() - this.getWidth()/3 - this.getWidth()/15, this.getHeight() - this.getHeight()/13);
        Point tempspawn = new Point(spawner.getX(), spawner.getY());
        this.removeObject(spawner);
        
        int[] EnemyperWave = new int[]{0, 6, 12, 20, 25, 38, 49};
        int[] tempspawnoffset = new int[]{0, 40, 20, 30, 25, 18, 8};

        setupAttributes();
        
        changeMoney(400);
        changeLifes(-5);
        setupLevel(EnemyperWave, tempspawnoffset, tempspawn, 2);
        
        //Ende
        End end = new End();
        this.addObject(end,0 + this.getWidth()/3 + this.getWidth()/17, 0 + this.getHeight()/37);
        
        
        //Wave start Button
        ButNextWave butNextWave = new ButNextWave();
        this.addObject(butNextWave,getWidth() - getWidth()/15, getHeight()/5);
        
        setupShop();
    }
    
    /**
     * Die Attribute werden erzeugt damit auf diese von der GameWorld zugegrifen werden kann.
     */
    private void setupAttributes()
    {
        this.addObject(new Attributes("Time: 0"), getWidth() - getWidth()/15, getHeight()/20);
        this.addObject(new Attributes(""), getWidth() - getWidth()/15, getHeight()/14);
        this.addObject(new Attributes(""), getWidth() - getWidth()/15, getHeight()/11);
        this.addObject(new Attributes(""), getWidth() - getWidth()/15, getHeight()/9);
    }
    
    /**
     * Die Shopbuttons werden eingerichtet mit entsprechenden Preisschielder darunter.
     */
    private void setupShop()
    {
        //Shop
        BuyButtonAutoTower towerbutton = new BuyButtonAutoTower();
        this.addObject(towerbutton,0 + getWidth()/15, getHeight()/10);
        
        int height = towerbutton.getImage().getHeight();
        
        Price pricenew = new Price(towerbutton.getprice() + "$");
        this.addObject(pricenew,0 + getWidth()/15, getHeight()/10 + height);
        
        BuyButtonManuelTower towerbutton2 = new BuyButtonManuelTower();
        this.addObject(towerbutton2,0 + getWidth()/15, getHeight()/10 + height*2);
        
        Price pricenew2 = new Price(towerbutton2.getprice() + "$");
        this.addObject(pricenew2,0 + getWidth()/15, getHeight()/10 + height*3);
        
        BuyBoom boomButton = new BuyBoom();
        this.addObject(boomButton, 0 + getWidth()/15, getHeight()/10 + + height*4);
        
        Price pricenew3 = new Price(boomButton.getprice() + "$");
        this.addObject(pricenew3,0 + getWidth()/15, getHeight()/10 + height*5);
    }
}
