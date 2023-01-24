import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Die Bullet wird dazu verwendet den Enemys Leben abzuziehen.
 * Sie hat ein Automatischen und einen Manuellen modi.
 * 
 * Der Manuelle Modi fliegt einfach gerade aus.
 * 
 * Der Automatische Modi fliegt einem spezifischen Gegner nach.
 * Falls dieser nicht mehr existiert sucht sie sich einen anderen Gegnähr in der nähe.
 * Falls es keinen Hat löscht sie sich selber.
 * 
 * Bullets treffen immer den ersten Gegner den sie berühren.
 * 
 * @author Matteo
 */
public class Bullet extends Actor
{
    private int dmg;
    private int speed = 8;
    
    private int maxrange;
    
    private boolean auto;
    private int retargetrange = 100;
    private Enemys target;
    
    /**
     * Constructor für eine Bullet die in eine Bestimmte richtung fliegt.
     * Die Richtung wird mit der Rotation bestimmt.
     * 
     * @param dmgtemp ist der Schaden der Bullet die einem Gegner macht.
     * @param rangetemp ist wie weit die Bullet fliegt in pixel.
     * @param rotation ist die Richtung in die die Bullet fliegt in Grad.
     */
    public Bullet(int dmgtemp, int rangetemp, int rotation)
    {
        auto = false;
        dmg = dmgtemp;
        
        maxrange = rangetemp;
        
        this.setRotation(rotation);
    }
    
    /**
     * Constructor für Bullet die dem target nachfliegt das dem Constructor gegeben wurde.
     * 
     * @param dmgtemp ist der Schaden der Bullet die einem Gegner macht.
     * @param targettemp ist das Ziel auf das die Bullet fliegt.
     */
    public Bullet(int dmgtemp, Enemys targettemp)
    {
        dmg = dmgtemp;
        auto = true;
        target = targettemp;
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Fals die Bullet Automatisch ist wird dementsprechend geschaut ob es diesen Enemy noch gibt sonst wird Bullet entfernt.
     * Falls das Target noch existiert wird die Automatische Bewegung durchgeführt und getestet ob ein Enemy berürt wird.
     * 
     * Falls die Bullet Manuel ist fliegt sie weiter.
     * Danach wird getestet ob sie am ende der Welt ist oder ob sie bereits über ihre Maximalreichweite geflogen ist.
     * Falls ja wird sie entfernt falls nicht wird getestet ob sie ein Gegner berührt.
     */
    public void act()
    {
        if(auto)
        {
            if(target.getWorld() == null)
            {
                if(retarget())
                {
                    moveauto();
                    touchEnemy();
                } else {
                    getWorld().removeObject(this);
                }
            } else {
                moveauto();
                touchEnemy();
            }
        } else
        {
            movemanuell();
            if(this.isAtEdge() || maxrange <= 0)
            {
                getWorld().removeObject(this);
            } else {
                touchEnemy();
            }
        }
    }
    
    /**
     * Bewegt sich weiter entsprechend zu ihrer Geschwindigkeit und zieht das von ihrer maxrange ab.
     */
    private void movemanuell()
    {
        this.move(speed);
        maxrange -= speed;
    }
    /**
     * Falls die Bullet einen Enemy berührt wird die removeLife() Methode dieses Enemys getrigert und die Bullet gelöscht.
     */
    private void touchEnemy()
    {
        Enemys enemy = (Enemys)getOneIntersectingObject(Enemys.class);
        
        if(enemy != null)
        {
            enemy.removeLife(dmg);
            getWorld().removeObject(this);
        }
    }
    /**
     * Dieser Mit der Automatischen Bewegung wird ausgerechnet um wie viel sich die Bullet auf jeder achse bewegen muss.
     * Danach wird getestet ob sie sich weiter bewegt als die Geschwindigkeit der Bullet falls ja wird diese auf die Geschwindikeit heruntergesetzt.
     * 
     * Danach setzt sich die Bullet an den neuen Ort.
     */
    private void moveauto()
    {
        int X = this.getX() - target.getX();
        int Y = this.getY() - target.getY();
        
        if(X > 0)
        {
            if(X > speed)
            {
                X = speed;
            }
        } else if (X < 0)
        {
            if(X < -speed)
            {
                X = -speed;
            }
        }
        if(Y > 0)
        {
            if(Y > speed)
            {
                Y = speed;
            }
        } else if (Y < 0)
        {
            if(Y < -speed)
            {
                Y = -speed;
            }
        }
        
        this.setLocation(this.getX()-X, this.getY()-Y);
    }
    
    /**
     * Bullet sucht sich ein neues Target aus falls ein Gegner in der nähe ist.
     * 
     * @return gibt zurück ob ein Gegner in der nähe gefunden wurde.
     */
    private boolean retarget()
    {
        List<Enemys> enemy = getObjectsInRange(retargetrange, Enemys.class);
        
        if(!enemy.isEmpty())
        {
            target = enemy.get(0);
            return true;
        } else {
            return false;
        }
    }
}
