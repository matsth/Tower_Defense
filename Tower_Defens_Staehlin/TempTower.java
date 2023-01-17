import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempTower extends Actor
{
    private int range;
    
    private int price;
    
    private Towers tower;
    
    private Range showrange;
    private boolean rangeok;
    
    /**
     * Erstelle einen Template Tower mit Preis, Tower der gekauft wird und der name des Bildes des Towers.
     * 
     * Das Bild wird auf den Bild des entsprechenden Towers geändert und die grösse wird angepasst.
     */
    public TempTower(int tempprice, Towers temptower, String imagetw)
    {
        range = temptower.getRange();
        price = tempprice;
        tower = temptower;
        
        rangeok = true;
        
        GreenfootImage image = new GreenfootImage( imagetw + ".png");
        image.scale(image.getWidth()/2, image.getHeight()/2);;
        this.setImage(image);
    }
    
    /**
     * Zuerst wird ein Range erstellt und die Farbe dieses wird angepasst wen nötig.
     * Danach wird sich zur Maus bewegt mit der movewithMouse() Methode.
     * 
     * Danach wird getestet ob die Transaktion abgebrochen wird.
     * Danach wird getestet ob der Tower gekauft wird.
     */
    public void act()
    {
        rangeandColor();
        movewithMouse();
        stopthis();
        buy();
    }
    
    /**
     * Eine Range wird erstellt falls es noch keinen gibt.
     * 
     * Danach wird getestet ob der Tower nicht über dem Pfad ist und auch keinen anderen Tower berührt.
     * Falls das so ist wird die Range farbe auf Grün geänder falls sie nochnicht Grün ist.
     * 
     * Falls nicht wird getestet ob die Range entweder den Pfad oder einen Tower berührt.
     * Falls das so ist und der Range nochnicht rot ist wird er auf Rot geänder.
     */
    private void rangeandColor()
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
    
    /**
     * Der TempTower und die Range bewegen sich zur Maus fals diese auf der Welt ist.
     */
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
    
    /**
     * Falls auf den Tower gecklicked wird und dieser nicht auf dem Pfad und auch nicht auf dem hintergrund ist wird der entsprechende Tower platziert der mitgegeben wurde.
     * Danach wird das Geld bgezochen mit der changeMoney() Methode.
     * Am schluss wird der TempTower und die Range mit der removethis() methode entfernt.
     */
    private void buy()
    {
        if(tower != null && Greenfoot.mouseClicked(this))
        {
            if(rangeok)
            {
                getWorld().addObject(tower,this.getX(), this.getY());
                ((GameWorld)getWorld()).changeMoney(-price);
                this.removethis();
            }
        }
    }
    /**
     * Checht ob der Hintergrund Schwarz ist.
     */
    private boolean testBackground()
    {
        return getWorld().getBackground().getColorAt(this.getX(), this.getY()).equals(Color.BLACK);
    }
    /**
     * Falls esc gedrückt wird wird der Tower und die Range entfernt.
     */
    private void stopthis()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            removethis();
        }
    }
    /**
     * Die Range wird entfernt fals vorhanden.
     * Der Tower wird entfernt.
     */
    public void removethis()
    {
        if(showrange != null)
        {
            getWorld().removeObject(showrange);
        }
        getWorld().removeObject(this);
    }
}
