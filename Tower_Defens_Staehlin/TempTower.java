import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempTower extends Actor
{
    public int range;
    
    public int price;
    
    public Towers tower;
    
    public Range showrange;
    public boolean rangeok;
    
    public TempTower(int tempprice, Towers temptower, String imagetw)
    {
        range = temptower.range;
        price = tempprice;
        tower = temptower;
        
        rangeok = true;
        
        GreenfootImage image = new GreenfootImage( imagetw + ".png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
    }
    
    public void act()
    {
        rangeandColor();
        movewithMouse();
        stopthis();
        buy();
    }
    
    public void rangeandColor()
    {
        if(showrange == null)
        {
            showrange = new Range(range);
            getWorld().addObject(showrange, this.getX(), this.getY());
        }
        
        if(!rangeok && !testBackground() && !this.isTouching(Towers.class))
        {
            rangeok = true;
            showrange.changeColor(rangeok);
        } else if(rangeok && (testBackground() || this.isTouching(Towers.class)))
        {
            rangeok = false;
            showrange.changeColor(rangeok);
        }
    }
    
    private void movewithMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           this.setLocation(mouse.getX(), mouse.getY());
           if(showrange != null)
           {
               showrange.setLocation(mouse.getX(), mouse.getY());
           }
        }
    }
    
    private void buy()
    {
        if(tower != null && Greenfoot.mouseClicked(this))
        {
            if(!testBackground() && !this.isTouching(Towers.class))
            {
                getWorld().addObject(tower,this.getX(), this.getY());
                ((GameWorld)getWorld()).changeMoney(-price);
                removethis();
            }
        }
    }
    
    private boolean testBackground()
    {
        return getWorld().getBackground().getColorAt(this.getX(), this.getY()).equals(Color.BLACK);
    }
    
    private void stopthis()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            removethis();
        }
    }
    
    public void removethis()
    {
        if(showrange != null)
        {
            getWorld().removeObject(showrange);
        }
        getWorld().removeObject(this);
    }
}
