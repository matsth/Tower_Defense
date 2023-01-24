import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eine Klasse die Dafür da ist Text anzuzeigen und zu ändern.
 * 
 * @author Matteo
 */
public class Text extends Actor
{
    /**
     * Dise Methode dient dazu Text anzupssen.
     * 
     * @param text ist der Text auf den das Objekt geändert werden soll.
     */
    public void setText(String text)
    {
        GreenfootImage image = null;
        image = new GreenfootImage(text, 20, Color.BLACK, null, null);
        this.setImage(image);
    }
}
