import greenfoot.*; 

public class YouWin extends World
{
    private GreenfootSound winSound;

    public YouWin()
    {
        super(500, 800, 1); // Atur ukuran dunia sesuai kebutuhan

        // Inisialisasi suara
        winSound = new GreenfootSound("win.wav");
        winSound.setVolume(100); // Atur volume suara
    }

    public void setImage(String imageName)
    {
        GreenfootImage background = getBackground();
        background.drawImage(new GreenfootImage(imageName), 0, 0);
    }

    // Metode untuk memainkan suara
    public void playWinSound()
    {
        winSound.play();
    }
}
