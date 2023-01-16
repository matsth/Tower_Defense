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
        movementspeed = 3;
        health = 10;
        damage = 1;
        value = 10;
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
        move(movementspeed);
        
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
