import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemynor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemynor extends Enemys
{
    private int pointOffset = this.getImage().getWidth()/2;
    private int pointAngle = 20;
    
    private int turnrate = 25;
    
    public Enemynor()
    {
        int movementspeed = 3;
        int health = 10;
        int damage = 1;
        int value = 10;
        
        setStats(new int[]{movementspeed, health, damage, value});
    }
    
    public void act()
    {
        if (!isPath(leftCol()))
        {
            turn(turnrate);
        }
        else if (!isPath(rightCol()))
        {
            turn(-turnrate);
        }
        move(getmove());
        
        touchEnd();
    }
    
    private Color leftCol()
    {
        Point sensorPoint = leftPoint();
        return getWorld().getBackground().getColorAt(sensorPoint.getX(), sensorPoint.getY());
    }

    private Color rightCol()
    {
        Point sensorPoint = rightPoint();
        return getWorld().getBackground().getColorAt(sensorPoint.getX(), sensorPoint.getY());
    }
    
    private boolean isPath (Color col)
    {
        return col.equals(Color.BLACK);
    }
    
    public Point leftPoint()
    {   
        return pointPosition(-pointAngle, pointOffset);
    }

    /**
     * Liefert die Position des rechten Auges.
     */
    public Point rightPoint()
    {
        return pointPosition(pointAngle, pointOffset);
    }

    public Point pointPosition(int angle, int distance)
    {
        double angleRad = Math.toRadians( getRotation() + angle);
        int x = (int) Math.round(getX() + Math.cos(angleRad) * distance);
        int y = (int) Math.round(getY() + Math.sin(angleRad) * distance);
        
        return new Point(x, y);
    }
}
