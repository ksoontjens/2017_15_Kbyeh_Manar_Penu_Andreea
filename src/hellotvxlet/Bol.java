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
    public int x = 200;
    public int y = 200;
    
    public Bol(){
        this.setBounds(0, 0, 510, 400);
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x, y, 20, 20);
           
    }
}

