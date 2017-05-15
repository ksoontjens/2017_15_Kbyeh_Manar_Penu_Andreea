package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HContainer;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


    
    
public class HelloTVXlet implements Xlet, HActionListener, UserEventListener
      
{
 hoofdgame gxlet;
 XletContext ctx;
    HContainer menu;
   HScene scene;
     


   HTextButton start;

   HStaticText text;
 static int highscoreNumber = 0;
 static int scoreNumber = 0;
 HStaticText highscore;
 HStaticText score;
 private scherm spelscherm;
 private int x,y;
 public int gedrukt = 0;


 public void setTextbox(HStaticText highscoreInit){
  highscore = highscoreInit;  
 }
 
 public void setScorebox(HStaticText scoreinit){
    score = scoreinit;
 }
 
 public int getHighscore(){
    return highscoreNumber;
 }
 
 public void updateScore(){
     scoreNumber ++;
     if(scoreNumber > highscoreNumber){
        highscoreNumber ++;
     }
     score.setTextContent("Score: " + scoreNumber, HStaticText.NORMAL_STATE);
     highscore.setTextContent("Highscore: " + highscoreNumber, HStaticText.NORMAL_STATE);
 }
 
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
            // Start de GameXlet
        scene=HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        menu=new HContainer(0,0,720,576); // volledig scherm
        menu.setBackground(Color.GREEN);
 
        
        text=new HStaticText("Welcome to snake the game.\n Press Enter to start.",450,150,500,300);
        
        text.setLocation(115,50);

     

        start=new HTextButton("Start",50,150,200,100);
        start.setBordersEnabled(true);
        start.setLocation(265,300);
        start.setBackground(Color.GREEN);
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

    public void pauseXlet() {

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
        manager.addUserEventListener( this,repository);
        

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

    public void respawn() throws XletStateChangeException
    {
        System.out.println("Restart Xlet!!!");
        gxlet.destroyXlet(true);
        scoreNumber = 0;
           gxlet.initXlet(ctx);
            gxlet.startXlet();
    }

    public void actionPerformed(ActionEvent e) {
      
  if(e.getActionCommand().equals( "start_knop" ))
        {
        
               // start GameXlet
               this.ctx=ctx;
           gxlet=new hoofdgame();
           managergame.getInstance().setApplicationManager(this);
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

    public void userEventReceived(UserEvent arg0) {
      
    }
  
     

     
  
}