
import greenfoot.*; 

public class Bullet extends Actor
{
    private int speed;
    public int damage;
    private int Bulletdirection;
    private int range;

    public Bullet() {
        this.speed = 2;
        this.Bulletdirection = Bulletdirection;
        this.damage = 1;
        this.range = range;

        
    }
        
    public void act()
    {
        move(speed);
    }

    private void checkCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null)
        {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
        }
    }
    

    
    

}
