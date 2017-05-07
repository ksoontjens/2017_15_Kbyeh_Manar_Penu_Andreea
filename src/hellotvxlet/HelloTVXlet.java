package hellotvxlet;

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


    
    
public class HelloTVXlet implements Xlet, HActionListener
      
{
 game gxlet;
 XletContext ctx;
    HContainer menu;
   HScene scene;
      public Speelveld veld;
   public Bol bol;
   public Slang slang;

   HTextButton start;

   HStaticText text;
 static int highscoreNumber = 0;
 static int scoreNumber = 0;
 HStaticText highscore;
 HStaticText score;

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
             tekenSpeelveld();
        tekenBol();
        tekenSlang();
    }

    public void pauseXlet() {

    }

    public void startXlet() throws XletStateChangeException {
    
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
           gxlet=new game();
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