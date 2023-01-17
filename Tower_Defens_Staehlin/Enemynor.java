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
    
    /**
     * Setzt die statistik dieses Gegners.
     */
    public Enemynor()
    {
        int movementspeed = 3;
        int health = 10;
        int damage = 1;
        int value = 10;
        
        setStats(new int[]{movementspeed, health, damage, value});
    }
    
    /**
     * Testet ob der Linke Punkt über Schwarz ist und danach ob der Rechte Punkt über Schwarz ist.
     * Falls Ja dreht sich dieser Enemy entsprechend.
     * 
     * Danach bewegt er sich weiter und testet ob er das Ende berührt mit der touchEnd() Methode.
     */
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
    
    /**
     * Der Linke Punkt wird erzeugt und die Farbe des Hintergrunds an diesem Punkt wird geholt.
     */
    private Color leftCol()
    {
        Point sensorPoint = leftPoint();
        return getWorld().getBackground().getColorAt(sensorPoint.getX(), sensorPoint.getY());
    }
    /**
     * Der Rechten Punkt wird erzeugt und die Farbe des Hintergrunds an diesem Punkt wird geholt.
     */
    private Color rightCol()
    {
        Point sensorPoint = rightPoint();
        return getWorld().getBackground().getColorAt(sensorPoint.getX(), sensorPoint.getY());
    }
    /**
     * Es wird getestet ob die mitgegebene Farbe Schwarz ist.
     * Falls ja wird true zurückgegeben sonst false.
     */
    private boolean isPath(Color col)
    {
        return col.equals(Color.BLACK);
    }
    
    /**
     * Liefert die Position des linken Auges.
     */
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
    
    
    /**
     * Zuerst wird der Winkelbogen zweier Radiuse ausgerechnet.
     * Danach werden die X und Y Kordinaten des Winkels ausgerechnet.
     * 
     * Zum Schluss wird ein neuer Punkt mit den ausgerechneten Kordinaten erstellt und auch ausgegeben.
     */
    public Point pointPosition(int angle, int distance)
    {
        double angleRad = Math.toRadians(getRotation() + angle);
        int x = (int) Math.round(getX() + Math.cos(angleRad) * distance);
        int y = (int) Math.round(getY() + Math.sin(angleRad) * distance);
        
        return new Point(x, y);
    }
}
