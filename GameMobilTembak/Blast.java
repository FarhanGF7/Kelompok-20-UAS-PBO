import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blast extends Props
{
    /**
     * Act - do whatever the Blast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter=0;
    public void act() 
    {
        // Add your action code here.
        counter++;
        if (counter==30)
        {
            getWorld().removeObject(this);
        }
    }    
}
