import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Towers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Towers extends Actor
{
    public Enemys findEnemy(int range)
    {
        List<Enemys> enemy = getObjectsInRange(range, Enemys.class);
        
        if(enemy.isEmpty())
        {
            return null;
        } else
        {
            return (enemy.get(0));
        }
    }
}
