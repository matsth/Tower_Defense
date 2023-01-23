/**
 * Der Point ist dafür da um einfacher einen Punkt auf der Map darzustellen.
 * 
 * @author Matteo
 */
public class Point  
{
    private int x;
    private int y;

    /**
     * Konstruktor für Objekte der Klasse Point.
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Liefert die x-Koordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Liefert die y-Koordinate.

     */
    public int getY()
    {
        return y;
    }
}
