import greenfoot.*; 
import java.util.List;

public class Tower extends Actor
{
    private int range;
    private int damage;
    private int rateOfFire;
    private int timeSinceLastShot;
    private List<Enemy> enemies;

    
     
    
    public Tower() {
        getImage().scale(70,70); 
        this.range = 100;
        this.damage = 20;
        this.rateOfFire = 60;
        this.timeSinceLastShot = 0;
        
    }
    
     public void addedToWorld(World world)
    {
        enemies = world.getObjects(Enemy.class);
    }
    

    
    private void EnemyOnRange ()
    {
       enemies = getObjectsInRange(100, Enemy.class);
       for(Enemy enemy : enemies)
       {
           Bullet bullet = new Bullet();
           getWorld().addObject(bullet, getX(),getY());
           bullet.turnTowards(enemy.getX(), enemy.getY());
       }
    }
    
        public void act() 
    {
    
        
    }

        
 }

   
   




