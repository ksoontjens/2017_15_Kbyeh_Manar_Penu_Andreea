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
    public int x = 18 * (int) ((Math.random()) * 40); //cols
    public int y = 18 * (int) ((Math.random()) * 24); //rows
    
    public Bol(){
        this.setBounds(0, 0, 800, 800);
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, 20, 20);
           
    }
}
