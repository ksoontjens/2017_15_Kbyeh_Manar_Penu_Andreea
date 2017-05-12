package hellotvxlet;
import java.awt.Color;

import java.awt.Font;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.UserEvent;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
public class game implements Xlet
      
{
    HStaticText highscore, score;
    int highscoreNumber = 0;
     int scoreNumber = 0;
    static HScene scene=null; // dit hoort bij de klasse niet het object
     boolean holdkey = false;
     
    boolean holdtimer = false;
 private scherm spelscherm;
    
    HelloTVXlet mainXlet;
       public Bol bol;
   public Slang slang;
       int initx = 0;
    int inity = 60;
    int rows = 28;
 int cols = 48;
    int squaresize = 15;
    int counttointerval = 0;
     int intervalat = 500;
       int timerinterval = 100;
      int direction = 3;
    
    int lengte = 10;
    int slanglengte = lengte;
       Segement[] snake;
    Blok[] grid;
    Segement food;
        private HStaticText lblGrid[] = new HStaticText[rows*cols];
      DVBColor snakecolor = new DVBColor(new DVBColor (1,1,1,1));
    DVBColor foodcolor = new DVBColor(new DVBColor (0,0,0,255));
   DVBColor gridcolor = new DVBColor(new DVBColor(15,45,250,111));
      

   Font myfont = new Font("Serif", Font.BOLD, 22);  

    public static HScene getScene()
    {
        return scene; 
    }



    public void setCallback(HelloTVXlet main)
    {
        mainXlet=main;
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        
       
        scene=HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        highscoreNumber = managergame.getInstance().getApplicationManager().getHighscore();
        highscore = new HStaticText("Highscore: " + highscoreNumber,530,20,300,400); //x, y, w ,h
        highscore.setVerticalAlignment(HStaticText.VALIGN_TOP);
        highscore.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        score = new HStaticText("Score: " + scoreNumber,70,20,300,400); //x, y, w ,h
        score.setVerticalAlignment(HStaticText.VALIGN_TOP);
        score.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        managergame.getInstance().getApplicationManager().setTextbox(highscore);
        managergame.getInstance().getApplicationManager().setScorebox(score);
    
        
  spelscherm = new scherm();       
        
           scene.add(spelscherm);

 
        scene.add(highscore);
        scene.add(score);
      
 
        scene.validate();
        scene.setVisible(true);
                //init grid
        for(int i = 0; i < rows*cols; i ++)
        {
            lblGrid[i] = new HStaticText("");
            lblGrid[i].setSize(squaresize-1,squaresize-1);
        
            lblGrid[i].setLocation(initx,inity);
        
        
            initx += squaresize;

                if(initx >= cols * squaresize)
                {
                    inity += squaresize;
                    initx = 0;
                }
        lblGrid[i].setBackground(gridcolor);
        lblGrid[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblGrid[i].setForeground(new DVBColor(0,0,0,255));
        lblGrid[i].setFont(myfont);        
        scene.add(lblGrid[i]);
        }
        //init virtual grid
        initx = 0;
        inity = 0;
        grid = new Blok[cols*rows];
        for (int i = 0; i < grid.length; i++)
        {
            grid[i] = new Blok(initx,inity);
            initx += squaresize;

                if(initx >= cols * squaresize)
                {
                    inity += squaresize;
                    initx = 0;
                }
        }
        

       
    

    }
 
    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        
    }
   

    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        		// Hide ourself and remove any components from the HScene
               
           
		scene.setVisible(false);
                

		// Dispose of our HScene
		HSceneFactory.getInstance().dispose(scene);
		scene = null;
    }
}


