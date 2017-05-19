package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;


public class hoofdgame  implements Xlet, UserEventListener, HActionListener
{
    
private HelloTVXlet mainXlet;
static HScene scene=null; 

    int gedrukt=0;
    private Slang nextSlang;
    private int x=350,y=200;
    private Bol bol;
  
    
tmrGame mtt;
    int initx = 0;
    int inity = 140;
    int rows = 24;
    int cols = 40;
    int squaresize = 18;
     private scherm speelveld;
    int initsnakelength = 10;
    int snakelength = initsnakelength;
    // HStaticText highscore, score;
    int score = 0;
    int highscore = 0;
    
    int highscoreNumber = 0;
    int direction = 3;
   
    int intervalat = 500; //ms
    int counttointerval = 0;
    int timerinterval = 500;
   
    boolean holdkey = false;
    boolean holdtimer = false;
        private boolean alive = true;
    
    
    ArrayList snake=new ArrayList();
    //classes
    
    Segement[] snakeA;
    
    Blok[] grid;
    Segement food;

        
    //MHP Stuff
  
    
    private HStaticText lblPoints = new HStaticText("score: 0");
    private HStaticText lblHighscore = new HStaticText("");
    private HStaticText lblGrid[] = new HStaticText[rows*cols];

    
    Font myfont = new Font("Serif", Font.BOLD, 22);    
       
    DVBColor backgroundcolor = new DVBColor(new DVBColor(0,100,0,255));
    DVBColor snakecolor = new DVBColor(new DVBColor (255,255,255,255));
    DVBColor foodcolor = new DVBColor(new DVBColor (0,0,0,255));
    DVBColor gridcolor = new DVBColor(new DVBColor(15,45,250,111));
   
    Timer t;
        private Timer timer;
    
    private HStaticText text;
    
    
    
 public static HScene getScene()
    {
        return scene; 
    }
    



    public void setCallback(HelloTVXlet main)
    {
        mainXlet=main;
    }
    
    public void initXlet(XletContext ctx) throws XletStateChangeException {
    {
        //MHP Stuff
        scene=HSceneFactory.getInstance().getDefaultHScene();
        scene.setBackground(Color.BLUE);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
       //init lblPoints
        lblPoints.setSize(125,40);
        lblPoints.setLocation(20,20);
        lblPoints.setBackground(new DVBColor(255,255,255,0));
        lblPoints.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblPoints.setFont(myfont);        
        scene.add(lblPoints);
        
        //init lblHighscore
        lblHighscore.setSize(125,40);
        lblHighscore.setLocation(20,20);
        lblHighscore.setBackground(new DVBColor(255,255,255,0));
        lblHighscore.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblHighscore.setFont(myfont);        
        scene.add(lblHighscore);
 speelveld = new scherm();       
        
           scene.add(speelveld);
           
         
           
           
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
        

       
        
        //initialize food
        food = new Segement(0, 0);
      
      
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        uev.addAllArrowKeys();
        EventManager.getInstance().addUserEventListener(this, uev);
        
         t = new Timer();
         mtt = new tmrGame();
        mtt.setCallbackHG(this);
        t.scheduleAtFixedRate(mtt,0,timerinterval);
       
        
        
        tekenBol();
    }
      
    }
    
    
    public void tekenBol(){
        bol = new Bol();
        scene.add(bol);
    }
    
    public void startXlet() 
    {
       
    }
    

    public void Paint()
    {
         System.out.println("paint begin");
         
         

        for (int i = 0; i < grid.length; i++)
            {
                //put snake on grid
                boolean showsnake = false;
                for (int j = 0; j < snakelength; j++)
		{
       //             if(grid[i].x == snake[j].x && grid[i].y == snake[j].y)
                    {
                        showsnake = true;
                    }
		}
               
                if(showsnake) // snake
                {
                    grid[i].issnake = true;
                    lblGrid[i].setBackground(snakecolor);

                }
            
            }
          System.out.println("paint einde");
    }
    

   

    public void pauseXlet() {
     System.out.println("pauseXlet");
    }

  public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        		// Hide ourself and remove any components from the HScene
               
           
		scene.setVisible(false);
                

		// Dispose of our HScene
		HSceneFactory.getInstance().dispose(scene);
		scene = null;
    }

    
   
        
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
            
            
        
        
        
      public void callback()
    {
            
            System.out.println("callback");
     //       Paint(); // update picbox even if not updated
            
            
              switch(gedrukt){
                case 3://rechts
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
    
                
            nextSlang = new Slang(x,y);
            scene.add(nextSlang);
                if (snake.size()>snakelength)
    {
       scene.remove((Slang)snake.get(0));
       
                    snake.remove(0); // eerste segmentje
        
       
    }
            
            
            
            scene.repaint();
            System.out.println("new slang at "+x+","+y);
            snake.add(nextSlang);
            
    
            
            
            overlapBol();
            overlapZichzelf();
           overlapVeld();
            
    }
      
   
      public void overlapBol(){
          System.out.println("slangX: " + x + " slangY: " + y);
          System.out.println("bolX: " + bol.x + " bolY: " + bol.y);
          
          if (Math.abs(x-bol.x)<20 && Math.abs(y-bol.y)<20) {
     
            //laat bol verdwijnen
              scene.remove(bol);
            //lengte slang vermeerderen
             snakelength++;
              
            //score aanpassen
            score++;
            lblPoints.setTextContent("score: " + Integer.toString(score),HVisible.NORMAL_STATE);
            
            scene.repaint(); //op random plek verschijnen
            tekenBol();
          }
          
          
      }
      
      
      public void overlapZichzelf(){
  if (snake.size()>0)
        for (int i = 0; i < snake.size()-1; i++)
            {
          
               if (((Slang)snake.get(i)).x == x && ((Slang)snake.get(i)).y == y){
               
                    holdtimer=true;
                     gameOver();
               }   
        }
      }
      
      
      public void overlapVeld(){
        if (x >= 710 || x <= -10 || y >= 560 || y <= 120){
        
            
           gameOver();
        }
      }
      
   private void gameOver() {
        System.out.println("game over");
 
        mtt.running=false;
        
        text = new HStaticText("GAME OVER!");
        
        text.setLocation(0,0);
        text.setSize(715,700);
        text.setBackground(new DVBColor(0,0,0,170));
        text.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        alive = false;
        
        scene.add(text);
        scene.repaint();
   
    }
    
    public void actionPerformed(ActionEvent e) 
    {
     
    }

  
   

    
    
}