package hellotvxlet;



import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventRepository;
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
    private int x,y;
    public int gedrukt = 0;
   
   
 
    
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
        
        //manager
        EventManager manager = EventManager.getInstance();
        //repository
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        //events toevoegen
        repository.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        
        //bekend maken bij manager
        manager.addUserEventListener(this, repository);
        

    }

    
    public void callback(){
              switch(gedrukt){
                case 3:
                      //rechts
                      x += 20;
                      break;
                case 1://onder
                      y += 20;
                      break;
                case 2: //links
                      x -= 20;
                      break;
                case 0: //boven
                      y -= 20;
                      break;
                default:
                      break;        
            }
    
              scene.repaint();
    
    }
    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

   

    public void actionPerformed(ActionEvent e) {
      
      
    }
    
    //opvangen van key events
    public void userEventReceived(org.dvb.event.UserEvent e){
        if(e.getType() == KeyEvent.KEY_PRESSED){
            switch(e.getCode()){
            
                case HRcEvent.VK_UP:
                    gedrukt = 0;
                    System.out.println("VK_UP is PRESSED");
                    break;
                case HRcEvent.VK_DOWN:
                    gedrukt = 1;
                    System.out.println("VK_DOWN is PRESSED");
                    break;
                case HRcEvent.VK_LEFT:
                    gedrukt = 2;
                    System.out.println("VK_LEFT is PRESSED");
                    break;
                case HRcEvent.VK_RIGHT:
                    gedrukt = 3;
                    System.out.println("VK_RIGHT is PRESSED");
                    break;
            
            }}}
    
    
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
