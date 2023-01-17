import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButNextWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("Space"))
        {
            ((GameWorld)getWorld()).nextRound();
        }
    }
}
