package hellotvxlet;

import java.awt.Color;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

import org.havi.ui.HVisible;

public class Spel implements Xlet
      
{

    static HScene scene=null; 

    boolean validX = false, validY = false;
 
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
      
       }
        
        
  
    
    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        
    }
    
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        		
		scene.setVisible(false);
              
		HSceneFactory.getInstance().dispose(scene);
		scene = null;
    }
}

