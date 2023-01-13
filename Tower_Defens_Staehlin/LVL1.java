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
    public int cash = 0;
    public int lifes = 5;
    
    public Spawner spawnpoint = null;
    
    private int timer = 0;
    private int ticker = 0; //60 ticks sind eine Sekunde
    
    private int[] spawnPerWave = {6, 12, 18, 25, 38, 49};
    private int[] spawnoffset = {40, 6, 30, 25, 18, 8};
    private int spawncounter = 0;
    private int currentWave = 0;
    private int currentspawend = spawnPerWave[currentWave];
    
    /**
     * Constructor for objects of class LVL1.
     *
     */
    public LVL1()
    {    
        //super(1200, 780, 1);
        prepare();
        setPaintOrder(Attributes.class, TowerAuto.class, Range.class, Enemynor.class, End.class, Bullet.class);
    }
    
    /**
     * Bereitet das Level vor.
     */
    private void prepare()
    {
        //remove
        TowerAuto towerAuto = new TowerAuto();
        addObject(towerAuto,334,301);
        //remove

        addObject(new Attributes("Time: " + timer), getWidth() - getWidth()/15, getHeight()/20);
        addObject(new Attributes("Money: " + cash), getWidth() - getWidth()/15, getHeight()/14);
        addObject(new Attributes("Lifes: " + lifes), getWidth() - getWidth()/15, getHeight()/11);
        addObject(new Attributes("Wafe " + (currentWave + 1) + " / " + spawnPerWave.length), getWidth() - getWidth()/15, getHeight()/9);
        
        //Ende
        End end = new End();
        addObject(end,getWidth() - getWidth()/3 + getWidth()/17, getHeight() - getHeight()/37);

        //Spawner
        Spawner spawner = new Spawner();
        addObject(spawner,getWidth()/4 - getWidth()/25, getHeight()/9);
        spawnpoint = spawner;
        
        ButNextWave butNextWave = new ButNextWave();
        addObject(butNextWave,getWidth() - getWidth()/15, getHeight()/5);
    }
    
    public void act()
    {
        ticking();
        if(monychange != 0)
        {
            changeMoney(monychange);
        }
        if(lifechange != 0)
        {
            changeLifes(lifechange);
        }
        if(nextwaveok)
        {
            nextRound();
        }
        spawner();
    }
    private void spawner()
    {
        spawncounter++;
        
        if(spawncounter >= spawnoffset[currentWave] && currentspawend > 0)
        {
            Enemynor enemy = new Enemynor();
            this.addObject(enemy, spawnpoint.getX(), spawnpoint.getY());
            enemy.turn(Greenfoot.getRandomNumber(359));
            currentspawend--;
            spawncounter = 0;
        }
    }
    /**
     * Jede 60zig ticks ist eine Sekunde.
     */
    private void ticking()
    {
        ticker++;
        
        if(ticker >= 60)
        {
            ticker = 0;
            timer++;
            oneSecond();
        }
    }
    /**
     * Wird jede Sekunde ausgeführt
     */
    private void oneSecond()
    {
        showTime();
    }
    /**
     * Ändert die Zeitanzeige auf die aktuellen Leben.
     */
    private void showTime()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(0);
        attribute.setText("Time: " + timer);
    }
    /**
     * Ändert das Geld.
     */
    public void changeMoney(int value)
    {
        cash += value;
        monychange = 0;
        showMoney();
    }
    /**
     * Ändert die Geldanzeige auf die aktuellen Leben.
     */
    private void showMoney()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(1);
        attribute.setText("Money: " + cash);
    }
    /**
     * Ändert die Leben.
     */
    public void changeLifes(int value)
    {
        lifes += value;
        lifechange = 0;
        showLifes();
        
        if(lifes <= 0)
        {
            Greenfoot.stop();
        }
    }
    /**
     * Ändert die Lifeanzeige auf die aktuellen Leben.
     */
    private void showLifes()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(2);
        attribute.setText("Lifes: " + lifes);
    }
    
    public void nextRound()
    {
        if(currentspawend <= 0)
        {
            List<Enemys> enemys = this.getObjects(Enemys.class);
            
            if(enemys.isEmpty())
            {
                if(currentWave + 1 >= spawnPerWave.length)
                {
                    Greenfoot.stop();
                } else {
                    
                    currentWave++;
                    showRound();
                    currentspawend = spawnPerWave[currentWave];
                    nextwaveok = false;
                }
            }
        }
    }
    
    /**
     * Ändert die Spielrundenanzeige auf die aktuellen Leben.
     */
    private void showRound()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(3);
        attribute.setText("Wafe " + (currentWave + 1) + " / " + spawnPerWave.length);
    }
}
