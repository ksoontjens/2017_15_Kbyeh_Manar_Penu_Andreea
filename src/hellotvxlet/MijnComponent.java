/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    int br, ho;

    public MijnComponent(int a, int b, int c, int d)
    {
     this.setBounds(a,b,c,d);
                   // links naar rechts, boven naar onder, breedte hoogte
     br = c;
     ho= d;


    }
    public void paint(Graphics g)
    {
        //g.drawLine(0, 0, 100, 100);
        g.setColor(new DVBColor(0,0,63,179));
        
        g.fillRoundRect(10, 10, br-10, ho-10, 15,15);
        g.setColor(new DVBColor(0,127,255,179));
        g.fillRoundRect(0, 0, br-10, ho-10, 15,15);
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("MijnComponent",50,50);

    }

}
