import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spells here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spells extends Text
{
    private Range spellrange;
    private int range;
    private int price;
    private boolean rangeadded = false;
    
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
    
    public void setprice(int value)
    {
        price = value;
    }
    
    public int getprice()
    {
        return price;
    }
    
    public Range returnRangeobj()
    {
        return spellrange;
    }
    
    public void setRange(int radius)
    {
        range = radius;
    }
    
    public int returnRange()
    {
        return range;
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
