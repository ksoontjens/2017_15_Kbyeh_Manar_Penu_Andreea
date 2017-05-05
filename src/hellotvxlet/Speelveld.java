/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;


    


/**
 *
 * @author student
 */
public class Speelveld extends HComponent {
   
public Speelveld(){
       this.setBounds(0, 0, 100, 100); //plaats en grootte instellen
    }
   
    
    public void paint(Graphics g){
        g.setColor(new DVBColor (155,221,126,255)); //groen
        g.fillRect(100,90,510,400); //speelveld
    }
}
