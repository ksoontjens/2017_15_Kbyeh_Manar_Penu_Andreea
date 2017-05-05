/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Slang extends HComponent {
    public int x = 400;
    public int y = 400;
    
    public Slang() {
       this.setBounds(0, 0, 1000, 1000); //plaats en grootte instellen
    }
   
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
    }
    
    
}
