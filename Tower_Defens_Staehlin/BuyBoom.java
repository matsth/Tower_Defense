import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dieser Button erstellt einen Boom Spell solange genügend Geld vorhanden ist.
 * 
 * @author Matteo
 */
public class BuyBoom extends Button
{
    private int size = 100;
    
    /**
     * Im Constructor wird die Grösse des Buttons angepasst und der Preis gesetzt.
     */
    public BuyBoom()
    {
        GreenfootImage image = new GreenfootImage("buttonBuyBoom.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
        setprice(100);
    }
    /**
     * Act - do whatever the BuyBoom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Testet ob der Button aktiviert wurde.
     */
    public void act()
    {
        cklicked();
    }
    /**
     * Testet ob der Button Angeklickt wurde oder der Shortcut verwendet wurde.
     * Danach wird ein neuer Spell Boom erzeugt.
     */
    public void cklicked()
    {
        if(cklickcheck("3"))
        {
            if(buyok())
            {
                Boom explosion = new Boom(getprice(), size);
                getWorld().addObject(explosion, this.getX(), this.getY());
            }
        }
    }
}
