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
     * 
     * @param x die x-Kordinaten dieses Punktes werden gesetzt.
     * @param y die y-Kordinaten dieses Punktes werden gesetzt.
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Liefert die x-Koordinate.
     * 
     * @return Gibt die x Kordinaten zurück.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Liefert die y-Koordinate.
     * 
     * @return Gibt die y Kordinaten zurück.
     */
    public int getY()
    {
        return y;
    }
}
