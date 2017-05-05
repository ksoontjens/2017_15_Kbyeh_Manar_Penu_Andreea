package hellotvxlet;



import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;


import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.ui.DVBColor;
import org.havi.ui.HContainer;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreenDimension;
import org.havi.ui.HScreenPoint;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, UserEventListener, HActionListener{
   HScene scene;
   
   HContainer menu;
   HContainer spel;

   HTextButton start;
   HStaticText text;
   
   XletContext ctx;
 
   public Speelveld veld;
   public Bol bol;
   public Slang slang;
   
   public HSceneTemplate sceneTemplate;
   
   private HStaticText scoreLbl;
   
   
 
    
    public void initXlet(XletContext arg0) throws XletStateChangeException {
      
        
      
        //SCHERM
        HSceneTemplate sceneTemplate = new HSceneTemplate();
       
        sceneTemplate.setPreference(
                org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION,
                    new HScreenDimension(1.0f, 1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,
                    new HScreenPoint(0.0f, 0.0f), org.havi.ui.HSceneTemplate.REQUIRED);
        
     
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        //ACHTERGROND
        scene.setBackground(new DVBColor(102,98,93,255));
        scene.setBackgroundMode(1);
        
        //LABEL
        scoreLbl = new HStaticText("SCORE: ");
        scoreLbl.setLocation(-60,-50); //links vanboven
        scoreLbl.setSize(400,250);
        scoreLbl.setBackground(Color.white);
        scene.add(scoreLbl);
        
        tekenSpeelveld();
        tekenBol();
        tekenSlang();
    }

    public void startXlet() throws XletStateChangeException {
        
       
        scene.validate();
        scene.setVisible(true);
        

    }

    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void userEventReceived(UserEvent e) {
        
    
    }

    public void actionPerformed(ActionEvent e) {
      
      
    }
    
    
     public void tekenSpeelveld(){
        veld = new Speelveld();
        scene.add(veld);
    }
     
     public void tekenBol(){
        bol = new Bol();
        scene.add(bol);
     }
     
     
      public void tekenSlang(){
        slang = new Slang();
        scene.add(slang);
     }
    
}
