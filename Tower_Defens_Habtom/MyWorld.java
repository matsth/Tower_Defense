import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public static int Money;
    
    int map [][] = {
                    {0,0,0,0,0,0,0,0,0,0},
                    {1,1,2,0,0,0,0,3,1,2},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,1,0,0,0,0,1,0,1},
                    {0,0,3,1,1,2,0,1,0,1},
                    {0,0,0,0,0,1,0,1,0,1},
                    {0,0,0,0,0,3,1,4,0,1}
                    };
                    
                    

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(14,12, 60); 
        Menu menu = new Menu();
        //addObject(menu, 240,94);
        Level1();
        //Enemy enemy = new Enemy();
        
    }
    
        public void act()
    {

        TowerClicked();
    }
    public void Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        for(int i = 0; i < 10 ; i++ )
        {
            for(int j = 0; j < 12 ; j++)
            {
                if(map [j][i] == 1)
                {
                    addObject(new Path(true), i, j);
                }
                
                if(map [j][i] == 2)
                {
                    addObject(new Path(90), i, j);
                }
                
                if(map [j][i] == 3)
                {
                    addObject(new Path(0), i, j);
                }
                
                if(map [j][i] == 4)
                {
                    addObject(new Path(270), i, j);
                }
            
            } 
        
        
        }
        
        
        
    }
    
    
    public void PrepareWorld()
    {

    
    }
    
        public void TowerClicked()
    {
        if(Greenfoot.mouseClicked(null) && Greenfoot.getMouseInfo().getActor() == null)
        {
        
        addObject(new Tower(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        
        }
    
    }

}
