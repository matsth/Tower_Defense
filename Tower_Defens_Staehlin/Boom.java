import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Bei Boom wird der Spelleffekt eingerichtet der die Gegner in der nähe zerstört.
 * 
 * @author Matteo
 */
public class Boom extends Spells
{
    private int dmg = 100;
    
    /**
     * Setzt die Reichweite und die Kosten dieses Spells.
     * Der Text BOOM! wird gesetzt.
     * 
     * @param tempprice setzt den Preis dieses Spells auf den Eingegebenen.
     * @param tempsize setzt die Reichweite des Spells auf die eingegebene.
     */
    public Boom(int tempprice, int tempsize)
    {
        setRange(tempsize);
        setprice(tempprice);
        
        this.setText("BOOM!");
    }
    /**
     * Act - do whatever the Boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Die Spellrange wird hinzugefügt falls sie noch nicht vorhanden ist.
     * Der Spell folgt der Maus.
     * Falls der Spell oder die Range angecklicked wurde wird er gekauft.
     * Falls esc gedrückt wird der Spell entfernt.
     */
    public void act()
    {
        addspellrange();
        followMous();
        buythis();
        stop();
    }
    /**
     * Falls der Spell(Boom) oder die Range angecklicked wird wird das Geld mit der changeMoney() Methode abgezogen.
     * Danach wird eine Liste der Gegner innerhalb der Reichweite erstellt.
     * 
     * Falls es mindestens ein Enemy in der Liste gibt wird für jedes Object die removeLife Methode durchgeführt.
     * Danach wird der Spell und die Range entfernt.
     */
    public void buythis()
    {
        if(Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(returnRangeobj()))
        {
            ((GameWorld)getWorld()).changeMoney(-getprice());
            List<Enemys> targets = getObjectsInRange(returnRange(), Enemys.class);
            
            if(!targets.isEmpty())
            {
                targets.forEach(target -> target.removeLife(dmg));
            }
            removethis();
        }
    }
}
