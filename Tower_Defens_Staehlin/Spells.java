import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hier werden die Dinge vom TempTower abgehandelt.
 * Dass ganze Kaufen von einem Spell.
 * Anzeigen der Range etc.
 * 
 * @author Matteo
 */
public class Spells extends Text
{
    private Range spellrange;
    private int range;
    private int price;
    private boolean rangeadded = false;
    
    /**
     * Der Spell mit der entsprechenden Range (fals vorhanden) folgt der Maus.
     */
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
    /**
     * Falls noch keine Range hinzugefügt wurde wird eine neue Erstellt.
     */
    public void addspellrange()
    {
        if(!rangeadded)
        {
            spellrange = new Range(range, true);
            getWorld().addObject(spellrange, this.getX(), this.getY());
            rangeadded = true;
        }
    }
    /**
     * Der Price des Spells wird gesetzt.
     * 
     * @param value setzt der Preis des Spells.
     */
    public void setprice(int value)
    {
        price = value;
    }
    /**
     * Der Price des Spells wird herausgegeben.
     * 
     * @return holt den Preis des Spells.
     */
    public int getprice()
    {
        return price;
    }
    /**
     * Das Range Object des Spells wird zurückgegeben.
     * 
     * @return Gibt die aktuelle Range zurück die verwendet wird.
     */
    public Range returnRangeobj()
    {
        return spellrange;
    }
    /**
     * Die Reichweite des Spells wird gesetzt.
     * 
     * @param radius setzt die Reichweite des Spells.
     */
    public void setRange(int radius)
    {
        range = radius;
    }
    /**
     * Die Reichweite des Spells wird zurückgegeben.
     * 
     * @return gibt die Reichweite des Spells zurück.
     */
    public int returnRange()
    {
        return range;
    }
    /**
     * Der Spell wird entfernt mit removethis() Methode falls esc gedrückt wird.
     */
    public void stop()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            removethis();
        }
    }
    /**
     * Entfernt die Range und das Spell Object aus der Welt.
     */
    public void removethis()
    {
            if(spellrange != null)
            {
                getWorld().removeObject(spellrange);
            }
            getWorld().removeObject(this);
    }
}
