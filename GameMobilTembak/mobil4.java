import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mobil4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mobil4 extends Karakter
{
    /**
     * Act - do whatever the mobil4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int type;
    public mobil4()
    {
        setImage("mobil4.png");
        setLocation(100,40);
    }
    public mobil4(int type)
    {
        setImage("mobil2"+type+".png");
    }
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
        getWorld().addObject(new mobil4(),Greenfoot.getRandomNumber(260)+50,0);
        Greenfoot.playSound("gameover.wav");
        getWorld().removeObject(this);
    }
}
 