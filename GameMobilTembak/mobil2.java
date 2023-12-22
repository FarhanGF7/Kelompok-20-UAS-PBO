import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mobil2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mobil2 extends Karakter
{
    /**
     * Act - do whatever the mobil2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(),getY()+2); 
        if (getY()>797)
        {
            setLocation(getX(),0); 
        }
        if (isTouching(Peluru.class))
        {
            MyWorld.score.add(10);
            removeTouching(Peluru.class);
            //Blast blast=new Blast();
            //getWorld().addObject(blast,getX(),getY());
            meledak();
        }
        else if (isTouching(mobil1.class))
        {
           removeTouching(mobil1.class);
           getWorld().addObject(new mobil1(),250,730);
           MyWorld.hp.add(-1);
           if (MyWorld.hp.getValue()==0)
           {
               getWorld().addObject(new GameOver(),250,400);
               MyWorld.hp.setValue(0);
               Greenfoot.stop(); 
           }
           meledak();
        }
    }
    void meledak()
    {
        getWorld().addObject(new Blast(),getX(),getY());
        getWorld().addObject(new mobil2(),Greenfoot.getRandomNumber(160)+10,0);
        Greenfoot.playSound("blast.wav");
        getWorld().removeObject(this);
    }    
}
