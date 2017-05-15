/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Bol extends HComponent {
    public int x = 300;
    public int y = 300;
    
    public Bol(){
        this.setBounds(0, 0, 1000, 1000);
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, 20, 20);
           
    }
}

