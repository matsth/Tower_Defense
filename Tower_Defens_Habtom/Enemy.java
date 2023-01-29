import greenfoot.*;
import java.util.List;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
   
    public int Enemyspeed;
    public int Enemylife;
    
      public Enemy()
    {
        // Add your action code here.
        GreenfootImage Enemyimage = new GreenfootImage("lobster.png");
        setImage(Enemyimage); 
        Enemyspeed = 1;
        Enemylife = 1;
        
    }
        /**
     * Move and follow the path. This is done by looking at the colour of the ground
     * at the position of the eyes. If the ground is not brown, turn a bit sideways.
     */
    public void act()
    {
        Enemymovement();
        
    }
    
    public void Enemymovement()
    {
      move(this.Enemyspeed);
      List <Path> Enemyroad90 = getObjectsAtOffset(0, 0, Path.class);
      
        for(Path paths:Enemyroad90)
            {
                if(paths.straight == false && getRotation() == 0)
                {
                    setRotation(paths.turn);
                }
            
            }
        
        List <Path> Enemyroad0 = getObjectsAtOffset(0, 0, Path.class);
        for(Path paths:Enemyroad0)
        {
            if(paths.straight == false && getRotation() == 90)
            {
                setRotation(paths.turn);
            }
        
        }
        
        List <Path> Enemyroad270 = getObjectsAtOffset(0, 0, Path.class);
              for(Path paths:Enemyroad270)
        {
            if(paths.straight == false && getRotation() == 270)
            {
                setRotation(paths.turn);
            }
        
        }      
        
    }
    
     private void PathReached()
    {
        // Add your action code here.
    }
     public void Enemydamage(int damage)
    {
        // Add your action code here.
        Enemylife -= damage;
        if ( Enemylife <= 0) {
            Defeat();
        }
    }
    
     public void Defeat()
    {
        // Add your action code here.
        //getWorld().removeObject(this);
        //GameWorld world = (GameWorld)getWorld();
        //world.addScore(reward);

    }
        

}
 
    
    


