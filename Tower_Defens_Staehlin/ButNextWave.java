import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dieser Button versucht die nächste Runde zu startetn.
 * Diese wird jedoch abgebrochen wenn noch Gegner auf dem Spielfeld sind oder noch nicht gespawnd wurden.
 * 
 * @author Matteo
 */
public class ButNextWave extends Button
{
    /**
     * Im Constructor wird die Grösse des Buttons angepasst.
     */
    public ButNextWave()
    {
        GreenfootImage image = new GreenfootImage("buttonNextWave.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
    }
    /**
     * Falls dieser Button angecklickt wird oder der Shortcut verwendet wurde wird versucht die neue Runde zu starten.
     * Dazu wird die nextRound() Methode aufgerufen.
     */
    public void act()
    {
        if(cklickcheck("Space"))
        {
            ((GameWorld)getWorld()).nextRound();
        }
    }
}
