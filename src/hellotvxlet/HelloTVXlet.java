package hellotvxlet;



import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;


import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HContainer;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
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
    Spel gxlet;
 XletContext ctx;
     
    
    public void initXlet(XletContext arg0) throws XletStateChangeException {
      
            // Start de GameXlet
        scene=HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.blue);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        menu=new HContainer(0,0,720,576); // volledig scherm
        menu.setBackground(Color.ORANGE);
 
        
        text=new HStaticText("Welcome to snake the game.\n Press Enter to start.",450,150,500,300);
        
        text.setLocation(115,50);
        

        
        
        
        
        start=new HTextButton("Start",50,150,200,100);
        start.setBordersEnabled(true);
        start.setLocation(265,300);
        start.setBackground(Color.ORANGE);
        start.setBackgroundMode(HVisible.BACKGROUND_FILL);
        start.setActionCommand("start_knop");
        start.addHActionListener(this);
        
        
       menu.add(text);
       menu.add(start);
       menu.setVisible(true);
          scene.add(menu);
               scene.validate();
        scene.setVisible(true);
        
        start.requestFocus();
    }

    public void startXlet() throws XletStateChangeException {
        
        

  //      spel.validate();
    //    spel.setVisible(false);

    }

    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException {
       
    }

    public void userEventReceived(UserEvent e) {
        
    
    }

    public void actionPerformed(ActionEvent e) {
      
if(e.getActionCommand().equals( "start_knop" ))
        {
        
               // start GameXlet
               this.ctx=ctx;
           gxlet=new Spel();
           manager.getInstance().setApplicationManager(this);
            try {
                scene.setVisible(false);
                menu.setVisible(false);
                gxlet.initXlet(ctx);
                gxlet.startXlet();
                
            } catch (XletStateChangeException ex) {
                ex.printStackTrace();
            }
            
            
      }
            
            
        
        
    }
    
}
