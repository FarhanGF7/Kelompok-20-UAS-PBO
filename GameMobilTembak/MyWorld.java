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
    public static Counter score = new Counter("Score : ");
    public static Counter hp = new Counter("HP : ");
    public static Counter time = new Counter("Time : ");
    GreenfootSound suara=new GreenfootSound("gamemusic.mp3");
    private int jeda = 1;
    private int nyawa = 3;
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1);
        prepare();// Check if the game should end
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        mobil1 mobil1 = new mobil1();
        addObject(mobil1,295,727);
        mobil1.setLocation(195,739);
        mobil2 mobil2 = new mobil2();
        addObject(mobil2,213,112);
        mobil4 mobil4 = new mobil4();
        addObject(mobil4,43,75);
        mobil2.setLocation(118,137);
        mobil2.setLocation(256,304);
        mobil2.setLocation(269,255);
        mobil2.setLocation(220,114);
        mobil4.setLocation(49,93);
        mobil2.setLocation(233,115);
        removeObject(mobil2);
        mobil4.setLocation(49,89);

        addObject(mobil4,200,124);
        addObject(mobil4,355,74);
        mobil4.setLocation(364,73);
        mobil4.setLocation(382,31);
        mobil1.setLocation(195,740);
        mobil1.setLocation(196,717);
        Peluru peluru = new Peluru();
        addObject(peluru,196,717);
        addObject(score,57,26);
        score.setLocation(400,25);
        score.setLocation(409,25);
        score.setValue(0);
        mobil4 mobil44 = new mobil4();
        addObject(mobil44,302,223);
        mobil44.setLocation(244,32);
        mobil44.setLocation(254,25);
        removeObject(mobil44);
        addObject(hp,100,25);
        hp.setValue(3);
        addObject(time,250,25);
        time.setValue(0);

        mobil2 mobil22 = new mobil2();
        addObject(mobil22,313,76);
        mobil2 mobil23 = new mobil2();
        addObject(mobil23,139,247);
    }

    public void act()
    {
        countTime(); 
        checkGameEnd(); 
    }
    
    private void countTime()
    {
        if (jeda > 0)
        {
            jeda--;
            return;
        }

        time.add(1); 

        jeda = 3; 
    }
    
    private void showTime()
    {
        showText("Time: " + time.getValue(), 200, 25);
    }
    
    private void checkGameEnd()
    {
        if (time.getValue() >= 300 || score.getValue() >= 100)
        {
            // Game ends, player wins
            YouWin youWin = new YouWin();
            Greenfoot.setWorld(youWin);
            youWin.playWinSound();
            Greenfoot.stop();
        }  
    }
    
    public void started()
    {
        suara.playLoop();
    }
}
