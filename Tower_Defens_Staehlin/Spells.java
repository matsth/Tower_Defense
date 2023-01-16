import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spells here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spells extends Text
{
    public Range spellrange;
    public int range;
    public int price;
    public boolean rangeadded = false;
    
    public void followMous()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           this.setLocation(mouse.getX(), mouse.getY());
           if(spellrange != null)
           {
               spellrange.setLocation(mouse.getX(), mouse.getY());
           }
        }
    }
    
    public void addspellrange()
    {
        if(!rangeadded)
        {
            spellrange = new Range(range, true);
            getWorld().addObject(spellrange, this.getX(), this.getY());
            rangeadded = true;
        }
    }
    
    public void stop()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            removethis();
        }
    }
    
    public void removethis()
    {
            if(spellrange != null)
            {
                getWorld().removeObject(spellrange);
            }
            getWorld().removeObject(this);
    }
}
