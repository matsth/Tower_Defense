import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyBoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyBoom extends Button
{
    private int size = 100;
    
    public BuyBoom()
    {
        GreenfootImage image = new GreenfootImage("buttonBuyBoom.png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
        price = 200;
    }
    /**
     * Act - do whatever the BuyBoom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        cklicked();
    }
    
    public void cklicked()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("3"))
        {
            if(buyok())
            {
                Boom explosion = new Boom(price, size);
                getWorld().addObject(explosion, this.getX(), this.getY());
            }
        }
    }
}
