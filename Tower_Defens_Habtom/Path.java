import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
   
    public class Path extends Actor
    {
        /**
         * Act - do whatever the Path wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        
        public int turn;
        public boolean straight;
        
        public Path(boolean straight)
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            getImage().scale(60, 60);
            this.straight = straight;
        }
        public Path(int turn)
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            getImage().scale(60, 60);
            this.turn = turn;
        }
        
        public void act()
        {
            // Add your action code here.
        }
    }
