package hellotvxlet;

import java.awt.Color;

import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
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
    

    
    HelloTVXlet mainXlet;

 

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
    
        

 
 
        scene.add(highscore);
        scene.add(score);
      
 
        scene.validate();
        scene.setVisible(true);
        
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


