import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public int cash;
    public int lifes;
    
    public int Level;
    
    public Point spawnpoint;
    
    public int timer = 0;
    private int ticker = 0; //60 ticks sind eine Sekunde
    
    public int[] spawnPerWave;
    public int[] spawnoffset;
    
    
    public int spawncounter = 0;
    public int currentWave = 0;
    public int currentspawend;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 780, 1);
        setPaintOrder(Button.class, Text.class, TempTower.class, Towers.class, Range.class, Enemynor.class, End.class, Bullet.class);
    }
    
    public void act()
    {
        ticking();
        spawner();
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
     * Ändert die Leben.
     */
    public void changeLifes(int value)
    {
        lifes -= value;
        showLifes();
        
        if(lifes <= 0)
        {
            gameOver();
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
    /**
     * 
     */
    public void gameOver()
    {
        EndScreen newWorld = new EndScreen(false, Level);
        Greenfoot.setWorld(newWorld);
    }
    /**
     * Ändert das Geld.
     */
    public void changeMoney(int value)
    {
        cash += value;
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
    
    private void spawner()
    {
        spawncounter++;
        
        if(spawncounter >= spawnoffset[currentWave] && currentspawend > 0)
        {
            if(Greenfoot.getRandomNumber(100) >= 10)
            {
                Enemynor enemy = new Enemynor();
                this.addObject(enemy, spawnpoint.getX(), spawnpoint.getY());
                enemy.turn(Greenfoot.getRandomNumber(359));
            } else {
                Enemydir enemy = new Enemydir();
                this.addObject(enemy, spawnpoint.getX(), spawnpoint.getY());
            }
            currentspawend--;
            spawncounter = 0;
        }
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
                    gameOn();
                } else {
                    currentWave++;
                    showRound();
                    currentspawend = spawnPerWave[currentWave];
                }
            }
        }
    }
    /**
     * 
     */
    public void gameOn()
    {
        EndScreen newWorld = new EndScreen(true, Level);
        Greenfoot.setWorld(newWorld);
    }
    /**
     * Ändert die Spielrundenanzeige auf die aktuellen Leben.
     */
    private void showRound()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(3);
        attribute.setText("Wave " + currentWave + " / " + (spawnPerWave.length - 1));
    }
}
