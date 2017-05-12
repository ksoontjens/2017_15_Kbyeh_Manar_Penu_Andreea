package hellotvxlet;


import org.havi.ui.*;
import java.awt.*;

/**
 *
 * @author student
 */
public class scherm extends HComponent  {
    
    
    public scherm(){
       this.setBounds(0, 0, 800, 800);
       
       
    }
   
    
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.drawRect(0, 60, 718,418);
        
        
        }
}
