import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Normaler Enemy der dem Pfad folgt.
 * Hier ist die Bewegung geregelt.
 * 
 * @author Matteo
 */
public class Enemynor extends Enemys
{
    private int pointOffset = this.getImage().getWidth()/2;
    private int pointAngle = 20;
    private Color Pfadfarbe = Color.BLACK;
    
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
        needTurn();
        this.move(getmove());
        
        touchEnd();
    }
    
    /**
     * Dreht sich fals nötig.
     */
    private void needTurn()
    {
        if (!pointCollor(-pointAngle).equals(Pfadfarbe))
        {
            turn(turnrate);
        }
        else if (!pointCollor(pointAngle).equals(Pfadfarbe))
        {
            turn(-turnrate);
        }
    }
    
    /**
     * Zuerst wird der Radians ausgerechnet.
     * X: Der Radians wird genommen und mit Cosinusfunktion mit dem Offset multipliziert. Dadurch erhält man den X Wert des gewünschten punktes.
     * Y: Gleich wie X aber die Sinusfunktion wird verwendet.
     * 
     * Mehr Infos unter:
     * https://math.stackexchange.com/questions/2390443/extracting-x-and-y-values-from-radians
     * 
     * Zum Schluss wird ein neuer Punkt mit den ausgerechneten Kordinaten erstellt und auch ausgegeben.
     * 
     * @param angle ist der Winkel auf dem der cosinus oder sinus angewendet wird.
     * @return ist die Farbe an dem ausgerechneten Punkt.
     */
    private Color pointCollor(int angle)
    {
        double angleRad = Math.toRadians(getRotation() + angle);
        int x = (int) Math.round(getX() + Math.cos(angleRad) * pointOffset);
        int y = (int) Math.round(getY() + Math.sin(angleRad) * pointOffset);

        return getWorld().getBackground().getColorAt(x, y);
    }
}
