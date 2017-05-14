package hellotvxlet;
import java.util.TimerTask;

public class tmrGame extends TimerTask {
    HelloTVXlet myXlet;
    
    public void setCallback (HelloTVXlet xlet)
    {
        myXlet = xlet;
    }
    
    public void run()
    {
        //System.out.println("tick");
        if(myXlet != null) { myXlet.callback(); }
        
    }

    void setCallback(hoofdgame aThis) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    

}