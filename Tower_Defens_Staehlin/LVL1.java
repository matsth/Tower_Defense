import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Level 1 ist das erste Level des Spiels.
 * In dieser Klasse wird vorallem die Platzierung der Kauf Buttons, des Endes und des Spawnpoint gesetzt.
 * Zusätzlich wird hir gesagt wieviele waves es Gibt und wie schnell die Enemys Spawnen.
 * 
 * @author Matteo
 */
public class LVL1 extends GameWorld
{
    /**
     * Constructor for objects of class LVL1.
     * Setzt das Level auf.
     */
    public LVL1()
    {
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
        this.addObject(spawner,getWidth()/4 - getWidth()/25, getHeight()/9);
        Point tempspawn = new Point(spawner.getX(), spawner.getY());
        this.removeObject(spawner);
        
        int[] EnemyperWave = new int[]{0, 6, 12, 20, 25, 38, 49};
        int[] tempspawnoffset = new int[]{0, 40, 20, 30, 25, 18, 8};        
        
        setupAttributes();
        
        changeMoney(400);
        changeLifes(-5);
        setupLevel(EnemyperWave, tempspawnoffset, tempspawn, 1);
        
        //Ende
        End end = new End();
        this.addObject(end,getWidth() - getWidth()/3 + getWidth()/17, getHeight() - getHeight()/37);
        
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
