package hellotvxlet;
import java.util.TimerTask;

public class tmrGame extends TimerTask {
    HelloTVXlet myXlet;
    hoofdgame myXletHG;
    public boolean running=true;
    
    public void setCallback (HelloTVXlet xlet)
    {
        myXlet = xlet;
    }
    
    public void run()
    {
      if (running) {
        if(myXlet != null) {   System.out.println("tick"); myXlet.callback(); }
         
        if(myXletHG != null) {   System.out.println("tick"); myXletHG.callback(); }     
      }
    }

    public void setCallbackHG(hoofdgame aThis) {
        myXletHG=aThis;
    }
    

}