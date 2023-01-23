import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Die Gameworld ist die Basis des Spiels.
 * Hier werden die Leben, Geld, Rundenanzeige verwaltet.
 * 
 * Zusätzlich wird das Spawnen der gegner hier abgehalten.
 * 
 * @author Matteo
 */
public class GameWorld extends World
{
    private int cash = 0;
    private int lifes = 0;
    
    private int Level;
    
    private Point spawnpoint;
    
    private int timer = 0;
    private int ticker = 0; //60 ticks sind eine Sekunde
    
    private int[] spawnPerWave;
    private int[] spawnoffset;
    
    
    private int spawncounter = 0;
    private int currentWave = 0;
    private int currentspawend;
    
    /**
     * Constructor for objects of class GameWorld.
     * Setzt die richtige Paintorder der Classen damit die wichtigen im Vordergrund sind.
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 780, 1);
        setPaintOrder(Button.class, Text.class, TempTower.class, Towers.class, Range.class, Enemynor.class, End.class, Bullet.class);
    }
    
    /**
     * Standard act() methode von Greenfoot.
     */
    public void act()
    {
        ticking();
        spawner();
    }
    
    /**
     * Jede 60zig ticks ist eine Sekunde.
     * Jede Sekunde wird der Timer hochgezelt und die neue Zeit angezeigt.
     */
    private void ticking()
    {
        ticker++;
        
        if(ticker >= 60)
        {
            ticker = 0;
            timer++;
            showTime();
        }
    }
    /**
     * Ändert die Zeitanzeige auf die Spielzeit in Sekunden.
     */
    private void showTime()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(0);
        attribute.setText("Time: " + timer);
    }
    
    /**
     * Ändert die Leben und führt die gameOver() methode aus falls 0 Leben ereicht werden.
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
     * Ändert die Lebensanzeige auf die aktuellen Leben.
     */
    private void showLifes()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(2);
        attribute.setText("Lifes: " + lifes);
    }
    /**
     * Falls 0 Lebenereicht werden wird auf den EndScreen gewechselt.
     * mit false wird gesagt dass das Spiel verloren wurde.
     */
    private void gameOver()
    {
        EndScreen newWorld = new EndScreen(false, Level, timer, currentWave);
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
     * Ändert die Geldanzeige auf das aktuele Geld.
     */
    private void showMoney()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(1);
        attribute.setText("Money: " + cash + "$");
    }
    /**
     * Gibt das aktuelle Geld aus.
     */
    public int money()
    {
        return cash;
    }
    
    /**
     * Setup für das Spiel.
     * Je nach Level können andere Gegner pro Runde geschickt und in verschiedene abstönden.
     * Zusätzlich wird auch noch der Punkt an dem die Gegner erzeugt werden gesezt und das aktuelle Level.
     */
    public void setupLevel(int[] enemysperwave, int[] cooldownperwave, Point tempspawn, int LVL)
    {
        spawnPerWave = enemysperwave;
        spawnoffset = cooldownperwave;
        
        currentspawend = spawnPerWave[currentWave];
        
        spawnpoint = tempspawn;
        Level = LVL;
        
        showRound();
    }
    
    /**
     * Der Spawner spawnt alle x ticks einen Enemy.
     * Hier wird entschieden was für eine Enemy gespawnt wird und auch kontrolliert das die Richtige anzal an gegner erzeugt wird.
     */
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
    /**
     * Hier wird die Rundenanzahl erhöht und die anzal der erzeugten Enemys wieder auf die aktuelle anzahl der Runde gesetzt.
     * Zuerst wird aber kontrolliert das alle Enemys gespawnd wurden und auch keine mehr auf der Map sind.
     * Falls die Letzte Runde gewonnen wurde wird die gameOn() methode aufgeruft.
     */
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
     * Falls die Letzte Runde gewonnen wurde wird auf den EndScreen gewechselt.
     * Mit true wird gesagt dass das Spiel gewonnen wurde.
     */
    private void gameOn()
    {
        EndScreen newWorld = new EndScreen(true, Level, timer, currentWave);
        Greenfoot.setWorld(newWorld);
    }
    /**
     * Ändert die Spielrundenanzeige auf die aktuellen Runde.
     */
    private void showRound()
    {
        Attributes attribute = this.getObjects(Attributes.class).get(3);
        attribute.setText("Wave " + currentWave + " / " + (spawnPerWave.length - 1));
    }
}
